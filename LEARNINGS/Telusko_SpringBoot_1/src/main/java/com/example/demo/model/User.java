package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class User {

	private int userId;
	private String userName;
	@Autowired
	@Qualifier("lap1")
	private Laptop laptop;  
	
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void show() {
		System.out.println(this.userId +" "+ this.userName);
		System.out.println(laptop.toString());
	}
}
