package com.coderUlagam.modal;

import org.springframework.stereotype.Component;

public class Employee {

	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	private String name;
	private Integer salary;
}
