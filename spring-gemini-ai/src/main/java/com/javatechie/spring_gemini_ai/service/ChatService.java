package com.javatechie.spring_gemini_ai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient chatClient;


    public ChatService(ChatClient.Builder geminichatClientBuilder) {
        this.chatClient = geminichatClientBuilder.build();
    }

    public String ask(String prompt){
        return chatClient.prompt(prompt)
                         .call()
                         .content();
    }
}
