package com.security.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.model.Product;
import com.security.model.UserInfo;
import com.security.repository.UserInfoRepository;

import jakarta.annotation.PostConstruct;

@Service
public class ProductService {
	
	List<Product> productList;
	
	/*
	 * @Autowired PasswordEncoder encoder;
	 */
	
	@Autowired
	UserInfoRepository userRepo;
	

	
	@PostConstruct
	public List<Product> loadProducts() {
		return productList = Arrays.asList(new Product(1,"ariel",100,10),new Product(2,"rin detergent",50,8));
	}

	public Product getById(int id) {
		return productList.stream().filter(prod -> prod.getProductId()==id).findAny().orElseThrow(()-> new RuntimeException("product not found"));
	}

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productList;
	}
	
	public String addUser(UserInfo userInfo) {
	 userInfo.setPassword(userInfo.getPassword());	
	 UserInfo user = userRepo.save(userInfo);
	 if(user == null) {
		 return "unable to save user";
	 }
	 return  "User Saved";
	}

}
