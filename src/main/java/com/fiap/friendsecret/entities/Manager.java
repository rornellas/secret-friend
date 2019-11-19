package com.fiap.friendsecret.entities;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    static Map<String, Object> response = new HashMap<>();
    static String questionBot;
    private String answerUser;


    public void setMessage(String answer) {
        this.answerUser = answer;
    }

    public void setResponse(Map<String, Object> response) {
        Manager.response = response;
    }

    public String checkMessage() {
        if ( questionBot == null) {
            questionBot = "Olá, seja Bem Vindo! Você gostatia de participar?";
        } else {
            try {
                Object result = response.get(questionBot);
                if (((HashMap) result).size() > 0) { questionBot = ((HashMap) result).get(answerUser.toUpperCase()).toString(); }
            } catch (Exception e) {
                questionBot = "Desculpe, não entendi sua resposta \n";
                e.getMessage();
            }
        }
        return questionBot;
    }
}
