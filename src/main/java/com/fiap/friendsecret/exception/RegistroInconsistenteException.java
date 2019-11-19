package com.fiap.friendsecret.exception;

public class RegistroInconsistenteException extends SecretFriendException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static String message;
	
	static {
		StringBuilder builder = new StringBuilder();
		builder.append("Registro inconsistente: Não é possível salvar! Favor verificar se preencheu todas as informações necessárias.");
		builder.append("Lembre-se que cada informação deve ser separada por \"*\"\n\n Lembre-se, o formato para se registrar é o seguinte:");
		builder.append(" /registrar *nome_do_amigo *referencia *presente_desejado *senha");
		
		message = builder.toString();
	}
	
	public RegistroInconsistenteException() {
		super(message);
	}
}
