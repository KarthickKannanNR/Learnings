package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;



@RestController
@RequestMapping("/employeeController")
public class EmployeeController {
	
	EmployeeService empService;
	
	public EmployeeController(EmployeeService empService) {
		this.empService = empService;
	}

	@PostMapping("/saveEmp")
	public ResponseEntity<EmployeeDTO> saveEmp(@RequestBody EmployeeDTO empDTO){
		return new ResponseEntity<EmployeeDTO>(empService.saveEmp(empDTO),HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public String welcome() {
		return "Working";
	}
}
