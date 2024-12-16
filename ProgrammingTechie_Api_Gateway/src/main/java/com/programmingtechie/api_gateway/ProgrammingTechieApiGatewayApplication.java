package com.programmingtechie.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class ProgrammingTechieApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgrammingTechieApiGatewayApplication.class, args);
	}

}
