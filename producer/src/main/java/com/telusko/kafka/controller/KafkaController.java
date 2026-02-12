package com.telusko.kafka.controller;

import com.telusko.kafka.model.Course;
import com.telusko.kafka.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/add-course")
    public ResponseEntity<String> addCourse(@RequestBody Course course){
        String response = kafkaProducerService.sendMessage(course);
        return new ResponseEntity<>(response,HttpStatus.CREATED);

    }
}
