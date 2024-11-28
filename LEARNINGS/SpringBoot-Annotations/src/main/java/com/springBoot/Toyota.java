package com.springBoot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Component;

@Component
public class Toyota implements Car{
	
	@Value("Toyota")
	private String carName;
	
	@Value("${spring.application.name}")
	private String applicationName;
	
	@Value("${java.home}")
	private String javaHome;
	
	
	@Override
	public void startCar() {
		System.out.println(carName +" engine on");
		System.out.println(applicationName+"\n"+ javaHome);
	}

}
