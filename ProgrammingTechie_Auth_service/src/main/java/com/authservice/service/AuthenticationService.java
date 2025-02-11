package com.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.authservice.DTO.AuthRequest;
import com.authservice.entity.UserInfo;
import com.authservice.repository.UserCredantialRepository;

@Service
public class AuthenticationService {

	private UserCredantialRepository repo;
	private PasswordEncoder encoder;
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	JwtService jwtService;
	@Autowired
	public AuthenticationService( UserCredantialRepository repo,PasswordEncoder encoder) {
		this.repo = repo;
		this.encoder = encoder;
	}
	
	public String saveUser(UserInfo userInfo) {
		userInfo.setPassword(encoder.encode(userInfo.getPassword()));
		repo.save(userInfo);
		return "User Added";
	}
	
	public String AuthenticateUser(AuthRequest request) {
		Authentication authentication =  authManager.authenticate(
				                                     new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
		String token;
		if(authentication.isAuthenticated()) {
			token = jwtService.generateToken(request.getUserName());
		}else {
			throw new RuntimeException("Invalid Credentials");
		}
		return token;
	}
	
}
