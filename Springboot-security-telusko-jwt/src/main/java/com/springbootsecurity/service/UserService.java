package com.springbootsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springbootsecurity.model.UserInfo;
import com.springbootsecurity.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	JWTService jwtService;
	
	public List<UserInfo> getAllUsers(){
		return userRepo.findAll();
	}

	public void adduser(UserInfo user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepo.save(user);
	}

	public String verify(UserInfo user) {
		Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));
		if(authentication.isAuthenticated()) 
			return jwtService.generateToken(user.getName());
		
		return "something went wrong";
	}
	
}
