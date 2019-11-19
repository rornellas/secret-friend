package com.fiap.friendsecret.decision;

import java.util.Map;

import com.pengrad.telegrambot.model.request.ChatAction;

class StartDecision extends AbstractDecision {

	public StartDecision(DecisionChain chain) {
		super(chain);
	}
	
	@Override
	public void processDecision(String text, Map<String, ChatAction> actions) {
		if("/start".equals(text)) {
			StringBuilder builder = new StringBuilder();
			builder.append("Olá, sou o bot FriendSecret!").append(System.lineSeparator());
			builder.append("Minha função é ajudar o amigo secreto a ganhar o presente correto!").append(System.lineSeparator());
			
			actions.put(builder.toString(), ChatAction.typing);

			builder = new StringBuilder();
			
			builder.append("Antes de começar, preciso saber: Você quer registrar o presente desejado, ou quer buscar o presente desejado por alguém?").append(System.lineSeparator()).append(System.lineSeparator());
			builder.append("Caso queira registrar, digite /registrar *nome_do_amigo *referencia *presente_desejado (Ex: /registrar *leonardo silva *FIAP *relógio swatch).").append(System.lineSeparator()).append(System.lineSeparator());
			builder.append("Caso queira ver se seu amigo secreto registrou algo aqui, digite /verificar *nome_do_amigo *referencia (Ex: /verificar *leonardo silva *FIAP)").append(System.lineSeparator()).append(System.lineSeparator());
			
			actions.put(builder.toString(), ChatAction.typing);
		} else {
			getNext().processDecision(text, actions);
		}
	}

}
