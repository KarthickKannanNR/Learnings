package com.telusko.kafka.controller;

import com.telusko.kafka.service.KafkaConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaConsumerService kafkaConsumerService;

    @PostMapping("/get-course")
    public ResponseEntity<String> getCourse(){
        String response = kafkaConsumerService.getMessage();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
