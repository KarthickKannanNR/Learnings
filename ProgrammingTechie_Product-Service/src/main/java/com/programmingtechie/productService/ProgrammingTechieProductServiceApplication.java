package com.programmingtechie.productService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.programmingtechie.productService.model.Product;
import com.programmingtechie.productService.repository.ProductRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan(basePackages = {"com.programmingtechie.productService"})
public class ProgrammingTechieProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgrammingTechieProductServiceApplication.class, args);
	}

	@Autowired
	private ProductRepository productrepository;
	
	@PostConstruct
	public void addProducts() {
		List<Product> productList = Arrays.asList(
				new Product("reddregon keyboard","it is a mechnical keyboard",new BigDecimal(2400)),
				new Product("Portronic Mouse","Rechargable mouse with, adjuctable dpi",new BigDecimal(499)),
				new Product("Ajas night lamp","5w reading lamp with rechargable",new BigDecimal(449))
				);
		productrepository.saveAll(productList);
	}
}
