package com.fiap.friendsecret.decision;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiap.friendsecret.repository.WishRepository;

@Component
public class DecisionChainFactory {

	@Autowired
	WishRepository wishRepository;
	
	public DecisionChain createDecisionChain() {
		RegistrarDecision registrar = new RegistrarDecision(new DefaultDecision(), wishRepository);
		VerificarDecision verificar = new VerificarDecision(registrar, wishRepository);
		HelpDecision help = new HelpDecision(verificar);
		StartDecision start = new StartDecision(help);
		
		return start;
	}

}
