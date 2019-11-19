package com.fiap.friendsecret.decision;

import java.util.List;

import com.fiap.friendsecret.model.ActionMessage;
import com.pengrad.telegrambot.model.request.ChatAction;

class HelpDecision extends AbstractDecision {

	public HelpDecision(DecisionChain chain) {
		super(chain);
	}

	@Override
	public void processDecision(String text, List<ActionMessage> actions) {
		if("/help".equals(text)) {
			StringBuilder builder = new StringBuilder();
			
			builder.append("Vamos lá. Você quer registrar o presente desejado, ou quer buscar o presente desejado por alguém?").append(System.lineSeparator()).append(System.lineSeparator());
			builder.append("Caso queira registrar, digite /registrar *nome_do_amigo *referencia *presente_desejado *sua_senha (Ex: /registrar *leonardo silva *FIAP *relógio swatch *senha).").append(System.lineSeparator()).append(System.lineSeparator());
			builder.append("Caso queira ver se seu amigo secreto registrou algo aqui, digite /verificar *nome_do_amigo *referencia (Ex: /verificar *leonardo silva *FIAP)").append(System.lineSeparator()).append(System.lineSeparator());
			
			actions.add(new ActionMessage(builder.toString(), ChatAction.typing));
		} else {
			getNext().processDecision(text, actions);
		}
	}

}
