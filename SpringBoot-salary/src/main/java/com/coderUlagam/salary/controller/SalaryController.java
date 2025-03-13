package com.coderUlagam.salary.controller;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("salary/")
public class SalaryController {

	@GetMapping("getSalary")
	public ResponseEntity<String> welcome(@RequestParam (value = "userName",required = false,defaultValue ="karthick") String userName) {
		return ResponseEntity.ok("Salary for "+userName +" is 100000");
	}
}
