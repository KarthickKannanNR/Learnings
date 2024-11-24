package com.telusko.demo;

import jakarta.validation.constraints.NotNull;

public class User {

	@NotNull
	private int userId;
	@NotNull
	private String userName;
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
}
