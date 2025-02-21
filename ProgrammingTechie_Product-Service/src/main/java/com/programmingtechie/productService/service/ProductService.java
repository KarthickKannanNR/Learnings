package com.programmingtechie.productService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programmingtechie.productService.dto.ProductRequest;
import com.programmingtechie.productService.dto.ProductResponse;
import com.programmingtechie.productService.model.Product;
import com.programmingtechie.productService.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;

	public void createProduct(ProductRequest productRequest) {
		Product product = new Product();
		product.setDescription(productRequest.getDescription());
		product.setName(productRequest.getName());
		product.setPrice(productRequest.getPrice());
		
		productRepo.save(product);
	}

	public List<ProductResponse> getAllProducts() {
		List<Product> products =  productRepo.findAll();
	    return products.stream().map(this::mapToProductResponse).toList();
	}
	
	private ProductResponse mapToProductResponse(Product product) {
		ProductResponse productresponse = new ProductResponse();
		productresponse.setDescription(product.getDescription());
		productresponse.setName(product.getName());
		productresponse.setPrice(product.getPrice());
		productresponse.setId(product.getId());
		return productresponse;
	}
}
