package com.fiap.friendsecret.exception;

public class BuscaInconsistenteException extends SecretFriendException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static String message;
	
	static {
		StringBuilder builder = new StringBuilder();
		builder.append("Busca inconsistente: Algum campo está faltando. Favor verificar se preencheu todas as informações necessárias.").append(System.lineSeparator()).append(System.lineSeparator());
		builder.append("Lembre-se que cada informação deve ser separada por \"*\" e o formato deve ser conforme o seguinte:");
		builder.append(" /verificar *nome_do_amigo *referencia");
		
		message = builder.toString();
	}
	
	public BuscaInconsistenteException() {
		super(message);
	}
}
