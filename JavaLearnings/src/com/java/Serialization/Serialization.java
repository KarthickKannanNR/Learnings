package com.java.Serialization;

import java.io.Serializable;

public class Serialization implements Serializable{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1569638446978331826L;
	private int id;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private String name;
	private int age;
	private String mobileNumber;

}
