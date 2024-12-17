package com.springbootsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootsecurity.model.UserInfo;
import com.springbootsecurity.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController()
@RequestMapping("/api/user/")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("getallusers")
	public List<UserInfo> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping("sendmsg")
	public String postMapChk(@RequestParam String msg) {
		return "postmapping is working";
	}
	
	@GetMapping("getcsrftoken")
	public CsrfToken getcsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
	
	@PostMapping("adduser")
	public UserInfo addUser(@RequestBody UserInfo user) {
		userService.adduser(user);
		return user;
	}
	
	@PostMapping("login")
	public String login(@RequestBody UserInfo user) {
		return userService.verify(user);
	}
}
