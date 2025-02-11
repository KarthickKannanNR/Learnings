package com.authservice.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
//@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.authservice.*","com.authservice.repository"})
@EnableJpaRepositories
public class ProgrammingTechieAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgrammingTechieAuthServiceApplication.class, args);
	}

}
