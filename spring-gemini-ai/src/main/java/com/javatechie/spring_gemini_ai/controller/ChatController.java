package com.javatechie.spring_gemini_ai.controller;

import com.javatechie.spring_gemini_ai.service.ChatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService){
        this.chatService = chatService;
    }

    @GetMapping("/ask")
    public ResponseEntity<String> ask(@RequestParam String prompt){
        String answer = chatService.ask(prompt);
        return new ResponseEntity<>(answer,HttpStatus.OK);
    }
}
