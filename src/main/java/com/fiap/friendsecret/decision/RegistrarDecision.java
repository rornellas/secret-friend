package com.fiap.friendsecret.decision;

import java.util.List;

import com.fiap.friendsecret.exception.RegistroInconsistenteException;
import com.fiap.friendsecret.model.ActionMessage;
import com.fiap.friendsecret.model.Wish;
import com.fiap.friendsecret.repository.WishRepository;
import com.pengrad.telegrambot.model.request.ChatAction;

class RegistrarDecision extends AbstractDecision {

	private WishRepository wishRepository;
	
	public RegistrarDecision(DecisionChain chain, WishRepository wishRepository) {
		super(chain);
		this.wishRepository = wishRepository;
	}
	
	@Override
	public void processDecision(String text, List<ActionMessage> actions) {
		if(text.startsWith("/registrar")) {
			String[] itens = text.split("\\*");
			
			if(itens.length < 5)
				throw new RegistroInconsistenteException();
			
			Wish buscar = wishRepository.registrar(itens[1].trim(), itens[2].trim(), itens[3].trim(), itens[4].trim());
			
			StringBuilder builder = new StringBuilder();

			builder.append("Seu registro foi realizado com sucesso! Verifique abaixo como ficou:").append(System.lineSeparator()).append(System.lineSeparator());
			builder.append("Nome: ").append(buscar.getNome()).append(System.lineSeparator());
			builder.append("Referência: ").append(buscar.getReferencia()).append(System.lineSeparator());
			builder.append("Presente desejado: ").append(buscar.getDesejo()).append(System.lineSeparator()).append(System.lineSeparator());
			builder.append("SENHA CADASTRADA: ").append(buscar.getSenha()).append(System.lineSeparator()).append(System.lineSeparator());
			builder.append("Caso haja algo de errado, por favor realize o procedimento novamente!");

			
			actions.add(new ActionMessage(builder.toString(), ChatAction.typing));
		} else {
			getNext().processDecision(text, actions);
		}
	}

}
