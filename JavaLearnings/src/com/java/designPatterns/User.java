package com.java.designPatterns;

public class User {

	private int userId;
	private String name;
	private int age;
	public int getUserId() {
		return userId;
	}
	public User setUserId(int userId) {
		this.userId = userId;
		return this;
	}
	public String getName() {
		return name;
	}
	public User setName(String name) {
		this.name = name;
		return this;
	}
	public int getAge() {
		return age;
	}
	public User setAge(int age) {
		this.age = age;
		return this;
	}
	
	
	
}
