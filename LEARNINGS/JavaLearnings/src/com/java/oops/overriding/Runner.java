package com.java.oops.overriding;

public class Runner {

	public static void main(String[] args) {
		Son son = new Son();
		son.work();
		
		Parent parent  = new Parent();
		parent.work();
		
		Parent parent2 = new Son();
		parent2.work();
		
		String k = "asfd";
		if(k.charAt(0) > k.charAt(1)) {}
		
	}

}
