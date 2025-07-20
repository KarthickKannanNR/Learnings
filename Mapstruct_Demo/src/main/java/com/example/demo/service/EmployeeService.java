package com.example.demo.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	EmployeeRepo empRepo;
	
	public EmployeeService(EmployeeRepo empRepo) {
		this.empRepo = empRepo;
	}

	public EmployeeDTO saveEmp(EmployeeDTO empDTO) {
		Employee emp = EmployeeMapper.EMP_MAPPER.populateEmployee(empDTO); 
		emp.setCreationDate(new Date());
		emp = empRepo.save(emp);
		return EmployeeMapper.EMP_MAPPER.populateEmployeeDTO(emp);
	}
	
	//After mapstruct this manual mapper is not needed
	public Employee mapEmployee(EmployeeDTO empDTO) {
		return Employee.builder().name(empDTO.getName())	
				                       .age(empDTO.getAge())
				                       .projectId(empDTO.getProjectId())
				                       .emailAddress(empDTO.getEmailAddress())
				                       .build();
	}

}
