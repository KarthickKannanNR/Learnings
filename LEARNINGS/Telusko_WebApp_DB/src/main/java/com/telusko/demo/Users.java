package com.telusko.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {
	@Id
	private Integer userId;
	private String userName;
	private String location;
	public int getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
    }
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", location=" + location + "]";
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
