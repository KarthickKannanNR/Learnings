package com.javaGuides.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.javaGuides.*"})
public class RequestCheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequestCheckApplication.class, args);
	}

}
