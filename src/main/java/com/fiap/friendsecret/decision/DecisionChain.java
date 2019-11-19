package com.fiap.friendsecret.decision;

import java.util.List;

import com.fiap.friendsecret.model.ActionMessage;

public interface DecisionChain {

	void processDecision(String text, List<ActionMessage> actions);
	
}
