package com.javaGuides.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaGuides.demo.entity.UserVO;
import com.javaGuides.demo.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	public List<UserVO> getAllUsers() {
		// TODO Auto-generated method stub
		userRepo.findAll().forEach((user) -> System.out.println(user.getUserName()));
		return userRepo.findAll(); 
	}
}
