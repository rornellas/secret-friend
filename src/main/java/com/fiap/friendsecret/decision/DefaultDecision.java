package com.fiap.friendsecret.decision;

import java.util.Map;

import com.pengrad.telegrambot.model.request.ChatAction;

class DefaultDecision implements DecisionChain {

	public DefaultDecision() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void processDecision(String text, Map<String, ChatAction> actions) {
		actions.put("Infelizmente não consegui entender...", ChatAction.typing);
		actions.put("Caso não saiba como prosseguir, digite /help para verificar as opções disponíveis.", ChatAction.typing);					
	}

}
