package com.javaGuides.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sprintSecurity.*","com.springSecurity.*"})
public class SpringBootSecurityJwt1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityJwt1Application.class, args);
	}

} 
