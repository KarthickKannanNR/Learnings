package com.springBoot;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigClass {
	
	
	@Bean(name = "hondaBean")
	public Honda honda() {
		return new Honda();
	}
	@Bean
	public Toyota toyota() {
		return new Toyota();
	}

	@Bean(initMethod = "init",destroyMethod = "destroy")
	public CarController carController() {
		return new CarController(toyota());
	}
}
