package com.fiap.friendsecret.model;

import com.pengrad.telegrambot.model.request.ChatAction;

public class ActionMessage {

	private String message;
	private ChatAction chatAction;
	
	public ActionMessage() {
		// TODO Auto-generated constructor stub
	}

	public ActionMessage(String message, ChatAction chatAction) {
		super();
		this.message = message;
		this.chatAction = chatAction;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ChatAction getChatAction() {
		return chatAction;
	}

	public void setChatAction(ChatAction chatAction) {
		this.chatAction = chatAction;
	}
	
}
