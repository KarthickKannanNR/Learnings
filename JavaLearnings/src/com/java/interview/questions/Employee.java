package com.java.interview.questions;

public class Employee {

	private int id;
	private String name;
	private double salary;
	private String status;
	
	public Employee(int id, String name, double salary, String status) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.status = status;
		
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", status=" + status + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
