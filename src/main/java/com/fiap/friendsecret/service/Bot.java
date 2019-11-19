package com.fiap.friendsecret.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fiap.friendsecret.decision.DecisionChain;
import com.fiap.friendsecret.decision.DecisionChainFactory;
import com.fiap.friendsecret.exception.SecretFriendException;
import com.fiap.friendsecret.model.ActionMessage;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

@Service
public class Bot {

    //objeto responsável por receber as mensagens
    private GetUpdatesResponse updatesResponse;

    //objeto responsável por gerenciar o envio de respostas
    private SendResponse sendResponse;

    //objeto responsável por gerenciar o envio de ações do chat
    private BaseResponse baseResponse;

    //controle de off-set, isto é, a partir deste ID será lido as mensagens pendentes na fila
    private Integer m=0;
    
    @Autowired
    TelegramBot bot;

    DecisionChain chain;
    
    @Autowired
    DecisionChainFactory decisionChainFactory;
    
    public Bot() {
	}
    
    @PostConstruct
    private void init() {
    	chain = decisionChainFactory.createDecisionChain();
    }
    
    @Scheduled(fixedDelay = 3000) 
    private void buscarMensagens() {
        //executa comando no Telegram para obter as mensagens pendentes a partir de um off-set (limite inicial)
    	this.updatesResponse =  this.bot.execute(new GetUpdates().limit(100).offset(m));

        //lista de mensagens
        List<Update> updates = this.updatesResponse.updates();

        //análise de cada ação da mensagem
        for (Update update : updates) {

            //atualização do off-set
        	this.m = update.updateId()+1;

            System.out.println("Recebendo mensagem:"+ update.message().text());

            Collection<ActionMessage> nextActions = checkActionForMessage(update.message().text());
            
            for (ActionMessage acao : nextActions) {
            	
            	//envio de "Escrevendo" antes de enviar a resposta
            	this.baseResponse = this.bot.execute(new SendChatAction(update.message().chat().id(), acao.getChatAction().name()));
            	
            	//verificação de ação de chat foi enviada com sucesso
            	System.out.println("Resposta de Chat Action Enviada?" + this.baseResponse.isOk());
            	
            	//envio da mensagem de resposta
            	this.sendResponse = this.bot.execute(new SendMessage(update.message().chat().id(),acao.getMessage()));
            	//verificação de mensagem enviada com sucesso
            	System.out.println("Mensagem Enviada?" +sendResponse.isOk());
			}
        }
	}

	private Collection<ActionMessage> checkActionForMessage(final String text) {
		List<ActionMessage> actions = new ArrayList<>();
		
		try {
			chain.processDecision(text, actions);
		} catch (SecretFriendException e) {
			actions.add(new ActionMessage(e.getMessage(), ChatAction.typing));
		} catch (Exception e) {
			actions.add(new ActionMessage("Ocorreu um erro desconhecido no aplicativo... por favor tente novamente", ChatAction.typing));
			e.printStackTrace();
		}
		
		return actions;
	}

}
