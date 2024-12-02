package com.coderUlagam.employees.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NameService {

	@Autowired
    private CircuitBreakerFactory circuitBreakerFactory;
	
	
	@Autowired private RestTemplate restTemplate;
	
	 @Autowired
	 public NameService(RestTemplate restTemplate) {
	     this.restTemplate = restTemplate;
	 }
	 
	
	
	public String callNameService() {
		
		CircuitBreaker cb = circuitBreakerFactory.create("nameServiceBreaker");
		//RestTemplate restTemplate = new RestTemplate();
		return cb.run(() -> restTemplate.getForObject("http://localhost:8087/api/name", String.class),throwable -> fallbackNameServiceCall());
	}
	
	public static String fallbackNameServiceCall() {
		return "Unable to get name";
	}
	
}
