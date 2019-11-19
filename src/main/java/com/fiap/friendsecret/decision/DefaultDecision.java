package com.fiap.friendsecret.decision;

import java.util.List;

import com.fiap.friendsecret.model.ActionMessage;
import com.pengrad.telegrambot.model.request.ChatAction;

class DefaultDecision implements DecisionChain {

	public DefaultDecision() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void processDecision(String text, List<ActionMessage> actions) {
		actions.add(new ActionMessage("Infelizmente não consegui entender...", ChatAction.typing));
		actions.add(new ActionMessage("Caso não saiba como prosseguir, digite /help para verificar as opções disponíveis.", ChatAction.typing));					
	}

}
