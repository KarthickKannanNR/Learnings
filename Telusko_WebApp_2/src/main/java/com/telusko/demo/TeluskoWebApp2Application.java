package com.telusko.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = "com.telusko.*")
public class TeluskoWebApp2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(TeluskoWebApp2Application.class, args);
		HomeController home =  context.getBean(HomeController.class);
		DummyConfig dc =  context.getBean(DummyConfig.class);
		dc.print();
	}

}
