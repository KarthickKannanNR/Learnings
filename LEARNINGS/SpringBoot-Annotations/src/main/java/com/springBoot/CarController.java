package com.springBoot;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.RestController;

public class CarController implements Car{

	
	Car car;
	
	
	
	@Override
	public void startCar() {
		car.startCar();
	}
	
	public CarController(Car car) {
		this.car = car;
	}

	public void init() {
		System.out.println("Init Method");
	}
	
	public void destroy() {
		System.out.println("destroy Method");
	}
}
