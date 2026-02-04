package com.example.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;

import com.example.repo.EmployeeRepo;

public class EmployeeService {
	
	EmployeeRepo empRepo;
	
	public EmployeeService(EmployeeRepo empRepo) {
		this.empRepo = empRepo;
	}

	public EmployeeDTO saveEmp(EmployeeDTO empDTO) {
		Employee emp = empRepo.save(mapEmployee(empDTO));
		empDTO = EmployeeMapper.EMP_MAPPER.populateEmployeeDTO(emp);
		return empDTO;
	}
	
	public Employee mapEmployee(EmployeeDTO empDTO) {
		return new Employee();
	}

}
