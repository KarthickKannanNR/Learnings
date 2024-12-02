package com.java.interview.questions;

public class Employee {

	private int id;
	private String name;
	private int salary;
	private String status;
	
	public Employee(int i, String string, int j, String string2) {
		this.id = id;
		this.name = string;
		this.salary = j;
		this.status = string2;
		
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", status=" + status + ", getId()="
				+ getId() + ", getName()=" + getName() + ", getSalary()=" + getSalary() + ", getStatus()=" + getStatus()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
