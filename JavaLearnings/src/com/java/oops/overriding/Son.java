package com.java.oops.overriding;

public class Son extends Parent{
	
	@Override
	public String parentMethod() {
		return "son";
	}
	
	public void childMethod() {
		System.out.println("child method");
	}
}
