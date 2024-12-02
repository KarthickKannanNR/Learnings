package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.User;

@SpringBootApplication
public class TeluskoSpringBoot1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext conf =  SpringApplication.run(TeluskoSpringBoot1Application.class, args);
		
		User userObj = conf.getBean(User.class);
		userObj.show();
	}

}
