package com.fiap.friendsecret.exception;

public class SenhaInvalidaException extends SecretFriendException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static String message;
	
	static {
		StringBuilder builder = new StringBuilder();
		builder.append("Senha inválida!").append(System.lineSeparator()).append(System.lineSeparator());
		builder.append("Para alterar um registro já existente, é necessário fornecer a senha que usou para o cadastro. Caso não tenha feito um registro, mude alguma informação no campo nome ou no campo referência.");
		
		message = builder.toString();
	}
	
	public SenhaInvalidaException() {
		super(message);
	}
}
