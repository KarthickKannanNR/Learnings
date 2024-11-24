package com.telusko.demo;

public class UserResponse {

	public UserResponse() {
		super();
	}
	private Integer id;
	public UserResponse(Integer id, String name, String username, String website) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.website = website;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	private String name;
	private String username;
	private String website;
}
