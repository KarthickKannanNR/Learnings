package com.java.oops.inheritence;

public class Child extends Parent{

	public void eatBiriyani() {
		System.out.println("child class eatBiriyani method called");
	}
	
	@Override
	public void eat() {
		System.out.println("child method eat called");
	}

}
