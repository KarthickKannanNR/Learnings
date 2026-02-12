package com.telusko.kafka.service;

import com.telusko.kafka.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    @Autowired
    private KafkaTemplate<String, Course> kafkaTemplate;

    @KafkaListener(topics = "course" , groupId = "course-group")
    public void consume(Course course){
        message = course + "course details received from kafka";
        System.out.println(message);
    }
}
