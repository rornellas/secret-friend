package com.fiap.friendsecret.decision;

abstract class AbstractDecision implements DecisionChain {

	private DecisionChain next;

	public AbstractDecision(DecisionChain chain) {
		setNext(chain);
	}
	
	public void setNext(DecisionChain chain) {
		this.next = chain;
	}
	
	public DecisionChain getNext() {
		return next;
	}

}
