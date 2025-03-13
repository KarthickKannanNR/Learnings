package com.springboot.controller;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("controller/")
public class FirstController {


	@GetMapping(value ="firstcontroller", produces = MediaType.TEXT_HTML_VALUE)
	public String getMessage() {
		return "Welcome.html";
	}
	
	@PostMapping("firstcontroller")
	public String getMsg(@RequestParam String name) {
		return "Welcome ".concat(name);
	}
}
