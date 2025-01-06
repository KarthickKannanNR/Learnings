package com.javaGuides.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaGuides.demo.entity.UserVO;
import com.javaGuides.demo.service.UserService;


@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("allUsers")
	//@Cacheable
	public ResponseEntity<List<UserVO>>  getAllUsers(){
		return new ResponseEntity<List<UserVO>>(userService.getAllUsers(),HttpStatus.OK);
	}
}
