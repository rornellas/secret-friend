package com.fiap.friendsecret.service;

import com.fiap.friendsecret.entities.Manager;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Memory {

    private Manager manager = new Manager();
    private Map<String, Object> question = new HashMap<>();

    public void loadResponse() {
        Map<String, String> response1 = new HashMap<>();
        response1.put("SIM", "Informe qual seu apelido ?");
        response1.put("NÃO", "Em que posso te ajudar ?");
        question.put("Olá, seja Bem Vindo! Você gostatia de participar?", response1);
        manager.setResponse(question);

        Map<String, String> response2 = new HashMap<>();
        question.put("Informe qual seu apelido ?", response2);
        manager.setResponse(question);

        Map<String, String> response3 = new HashMap<>();
        question.put("Desculpe, não entendi sua resposta \n", response3);
    }
}
