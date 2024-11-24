package com.java.oops.overriding;

public class Son extends Parent{
	public void work() {
		System.out.println("son work");
	}
	
	@Override
	public String parentMethod() {
		return "son";
	}
}
