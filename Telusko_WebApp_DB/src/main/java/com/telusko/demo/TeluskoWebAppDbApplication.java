package com.telusko.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication 
public class TeluskoWebAppDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeluskoWebAppDbApplication.class, args);
	}

}
