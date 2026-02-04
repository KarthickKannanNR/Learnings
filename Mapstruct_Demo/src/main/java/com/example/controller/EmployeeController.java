package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDTO;

import com.example.service.EmployeeService;

@RestController
@RequestMapping("employeeController/")
public class EmployeeController {
	
	EmployeeService empService;
	
	public EmployeeController(EmployeeService empService) {
		this.empService = empService;
	}

	public ResponseEntity<EmployeeDTO> saveEmp(EmployeeDTO empDTO){
		return new ResponseEntity<EmployeeDTO>(empService.saveEmp(empDTO),HttpStatus.CREATED);
	}
}
