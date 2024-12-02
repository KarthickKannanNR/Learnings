package com.springboot.entity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan(basePackages = {"com.springboot.*"})
@EnableJpaRepositories("com.springboot.*") // Adjust package name as necessary
@EnableTransactionManagement
@EnableCaching
@SpringBootApplication
public class SpringBootDataJpaApplication { 
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
	}
	

}
