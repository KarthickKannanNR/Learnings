package com.java.oops;

public class Child1 extends Parent1{
	
	Child1(int a){
		super(10);
		System.out.println("child constructor2 : "+a);
	}
	
	Child1(){
		this(8);
		System.out.println("child constructor called");
	}
	
	@Override
	public  void print() {
		System.out.println("child1");
	}
	
	public static void staticMethod() {
		System.out.println("child Static method");
	}
	
	@Override
	public Integer add(int n) {

		return n;
	}
}
