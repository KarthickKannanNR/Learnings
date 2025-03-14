package com.springboot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.UserCreationRequest;
import com.springboot.entity.Product;
import com.springboot.entity.UserVO;
import com.springboot.service.ProductService;
import com.springboot.service.UserService;


@RestController
public class HomeController {

	@Autowired
	private UserService userService;
	
	private ProductService productService;
	
	@Autowired
	public HomeController(ProductService productService) {
		this.productService = productService;
	}
	
	@PostMapping("addUser")
	public String addUser(@RequestBody UserVO user) {
		String message;
		user = userService.saveUser(user);
		if(user != null) {
			message =  "User Added Sucessfully";
		}else {
			message = "something Went Wrong";
		}
		
		return message;
	}
	
	@GetMapping("findUser")
	//@Cacheable(value = "userCache" ,key = "#userId")
	public UserVO findUser(@RequestParam int userId) throws Exception {
		return userService.findUserById(userId);
	}

	@GetMapping("allUsers")
	//@Cacheable
	public ResponseEntity<List<UserVO>>  getAllUsers(){
		return new ResponseEntity<List<UserVO>>(userService.getAllUsers(),HttpStatus.OK);
	}
	
	
	@GetMapping("findByRole")
	public List<UserVO> getEmployeeByRole(@RequestParam String role){
		return userService.getEmployeeByRole(role);
	}
	
	@GetMapping("getAgeUsingJPQL")
	public List<UserVO> getAgeUsingJPQL(@RequestParam int age){
		return userService.getAgeUsingJPQL(age);
	}

	@GetMapping("getAgeUsingSQL")
	public List<UserVO> findAgeUsingSQL(@RequestParam int age){
		return userService.findAgeUsingSQL(age);
	} 
	
	@GetMapping("findAgeUsingMethod")
	public List<UserVO> findAgeUsingMethod(@RequestParam int age){
		return userService.findAgeUsingMethodSyntax(age);
	} 
	
	@GetMapping("sortedUser")
	public List<UserVO> listEmployeeBySortig(String field){
		return userService.listEmployeeBySortig(field);
	}
	
	@GetMapping("pagiatedUser") 
	public Page<UserVO> listEmployeeWithPagination(int pageNumber,int pageSize,String field){
		return userService.listEmployeeWithPagination(pageNumber, pageSize,field);
	}
	
	@GetMapping("greet")
	public String greet(){ 
		return "welcome";
	}
	
	@DeleteMapping("removeUser")
	public ResponseEntity<String> deleteUser(@RequestParam int userId){
		String msg ="";
		boolean result = userService.deleteUser(userId);
		if(result) {
			msg ="something went wrong, check the given userId is valid";
		}else {
			msg ="user removed successfully";
		}
		return new ResponseEntity<String> (msg,result?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("createPrimeUser")
	public String createPrimeUser(@RequestBody UserCreationRequest creationRequest) {
		String msg = userService.createPrimeUser(creationRequest);
		return msg;
	}
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts(){
		return productService.getAllProduct();
		
	}
	
}
