package com.java.learnings.java8;

import java.util.List;

public class Employee {

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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public List<Projects> getProjects() {
		return projects;
	}
	public void setProjects(List<Projects> projects) {
		this.projects = projects;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getGender() {
		return gender;
	}
	public Employee(int id, String name, String dept, List<Projects> projects, double salary, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.projects = projects;
		this.salary = salary;
		this.gender = gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	private int id;
	private String name;
	private String dept;
	private List<Projects> projects;
	private double salary;
	private String gender;
	
	
}
