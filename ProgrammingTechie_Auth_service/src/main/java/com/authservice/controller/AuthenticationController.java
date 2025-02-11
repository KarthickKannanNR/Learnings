package com.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authservice.DTO.AuthRequest;
import com.authservice.DTO.AuthResponse;
import com.authservice.service.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

	private AuthenticationService authService;
	
	@Autowired
	public AuthenticationController(AuthenticationService authService) {
		this.authService = authService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request){
		return ResponseEntity.ok(new AuthResponse(authService.AuthenticateUser(request)));
	}
}
