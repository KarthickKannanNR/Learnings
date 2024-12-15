package com.programmingtechie.inventoryService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.programmingtechie.*"})
public class ProgrammingTechieInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgrammingTechieInventoryServiceApplication.class, args);
	}

}
