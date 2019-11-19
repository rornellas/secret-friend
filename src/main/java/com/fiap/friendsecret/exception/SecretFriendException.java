package com.fiap.friendsecret.exception;

public abstract class SecretFriendException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SecretFriendException(String message) {
		super(message);
	}
}
