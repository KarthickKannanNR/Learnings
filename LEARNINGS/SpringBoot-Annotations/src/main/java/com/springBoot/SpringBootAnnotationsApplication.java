package com.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootAnnotationsApplication {

	public static void main(String[] args) {
		
	  ConfigurableApplicationContext contx = SpringApplication.run(SpringBootAnnotationsApplication.class, args);
	  
	  
	  CarController controller = contx.getBean(CarController.class); 
	  controller.startCar();
	  
//	  Honda honda = (Honda) contx.getBean("hondaBean");
//	  honda.startCar();
	  
	  
//	  Toyota toyota = contx.getBean(Toyota.class);
//	  toyota.startCar();
	}

}
