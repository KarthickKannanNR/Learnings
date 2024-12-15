package com.programmingtechie.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.programmingtechie.orderservice.*"})
public class ProgrammingTechieOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgrammingTechieOrderServiceApplication.class, args);
	}

}
