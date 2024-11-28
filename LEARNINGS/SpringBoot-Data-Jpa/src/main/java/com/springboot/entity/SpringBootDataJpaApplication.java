package com.springboot.entity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springboot.*"})
@EnableJpaRepositories("com.springboot.*") // Adjust package name as necessary

public class SpringBootDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);

	}

}
