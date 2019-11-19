package com.fiap.friendsecret.decision;

import java.util.Map;

import com.pengrad.telegrambot.model.request.ChatAction;

public interface DecisionChain {

	void processDecision(String text, Map<String, ChatAction> actions);
	
}
