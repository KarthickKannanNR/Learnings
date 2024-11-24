package com.coderUlagam.employees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.coderUlagam.*"})
public class SpringBootEmployeesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmployeesApplication.class, args);
	}

}
