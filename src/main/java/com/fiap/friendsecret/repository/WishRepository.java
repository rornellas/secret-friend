package com.fiap.friendsecret.repository;

import java.util.HashMap;

import com.fiap.friendsecret.exception.SenhaInvalidaException;
import com.fiap.friendsecret.model.Wish;

public class WishRepository {

	private static HashMap<String, Wish> amigosCadastrados = new HashMap<>();
	
	public Wish registrar(String nome, String referencia, String desejo, String senha) {
		Wish wish = new Wish(nome, referencia, desejo, senha);
		
		String id = wish.generateId();
		
		Wish wishRegistrado = amigosCadastrados.get(id);
		
		if(wishRegistrado != null && !wishRegistrado.getSenha().equals(senha.trim()))
			throw new SenhaInvalidaException();
		
		amigosCadastrados.put(id, wish);
		
		return wish;
	}
	
	public Wish buscar(String nome, String referencia) {
		Wish wish = null;
		
		wish = amigosCadastrados.get(new Wish(nome, referencia).generateId());
		
		return wish;
	}
	
}
