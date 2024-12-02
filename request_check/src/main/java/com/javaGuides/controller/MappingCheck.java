package com.javaGuides.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingCheck {
	
	@RequestMapping("/message")
	public String message() {
		return "hi";
	}

}
