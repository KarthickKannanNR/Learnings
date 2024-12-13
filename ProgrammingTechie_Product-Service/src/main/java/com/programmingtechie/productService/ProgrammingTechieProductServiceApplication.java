package com.programmingtechie.productService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.programmingtechie.productService"})
public class ProgrammingTechieProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgrammingTechieProductServiceApplication.class, args);
	}

}
