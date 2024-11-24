package com.telusko.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.availability.ApplicationAvailabilityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.telusko.demo2.Demo2;

@EnableAutoConfiguration()
@ComponentScan(basePackages = {"com.telusko.demo"})
@Import({Demo2.class})
public class TeluskoWebApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(TeluskoWebApp1Application.class, args);
	}

}
