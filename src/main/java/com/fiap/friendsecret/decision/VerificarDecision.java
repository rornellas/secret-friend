package com.fiap.friendsecret.decision;

import java.util.List;

import com.fiap.friendsecret.exception.BuscaInconsistenteException;
import com.fiap.friendsecret.model.ActionMessage;
import com.fiap.friendsecret.model.Wish;
import com.fiap.friendsecret.repository.WishRepository;
import com.pengrad.telegrambot.model.request.ChatAction;

class VerificarDecision extends AbstractDecision {

	private WishRepository wishRepository;
	
	public VerificarDecision(DecisionChain chain, WishRepository wishRepository) {
		super(chain);
		this.wishRepository = wishRepository;
	}
	
	@Override
	public void processDecision(String text, List<ActionMessage> actions) {
		if(text.startsWith("/verificar")) {
			String[] itens = text.split("\\*");
			
			if(itens.length < 3)
				throw new BuscaInconsistenteException();
			
			Wish buscar = wishRepository.buscar(itens[1].trim(), itens[2].trim());
			
			StringBuilder builder = new StringBuilder();

			if(buscar == null) {
				builder.append("Não foi possível encontrar esse amigo...").append(System.lineSeparator());
				builder.append("Verifique se digitou os dados corretamente. Caso o tenha feito, divulgue nosso serviço para aumentar as chances do seu amigo se cadastrar!").append(System.lineSeparator());				
			} else {
				builder.append("Legal! Seu amigo deixou um registro aqui! Verifique abaixo:").append(System.lineSeparator()).append(System.lineSeparator());
				builder.append("Nome: ").append(buscar.getNome()).append(System.lineSeparator());
				builder.append("Referência: ").append(buscar.getReferencia()).append(System.lineSeparator());				
				builder.append("Presente desejado: ").append(buscar.getDesejo()).append(System.lineSeparator());				
			}

			actions.add(new ActionMessage(builder.toString(), ChatAction.typing));
		} else {
			getNext().processDecision(text, actions);
		}
	}

}
