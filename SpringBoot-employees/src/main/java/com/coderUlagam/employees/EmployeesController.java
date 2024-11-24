package com.coderUlagam.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderUlagam.employees.service.NameService;
import com.coderUlagam.modal.Employee;

@RestController
public class EmployeesController {

	@Autowired
	private NameService nameService;
	
	@GetMapping
	@RequestMapping("/api/employees")
	public Employee getEmployeeDetails() {
		Employee employee = new Employee();
		String name = nameService.callNameService();
		employee.setName(name);
		employee.setSalary(100000);
		return employee;
	}
}
