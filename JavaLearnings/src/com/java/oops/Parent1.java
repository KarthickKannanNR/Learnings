package com.java.oops;

public class Parent1 {

	Parent1(int b){
		System.out.println("parent constructor 2 : "+ b);
	} 
	Parent1(){
		System.out.println("parent constructor called");
	}
	
	public void print(){
	System.out.println("parent");	
	}
	public void name() {
		System.out.println("car");
	}
	public static void staticMethod() {
		System.out.println("parent Static method");
	}
	
	public Number add(int n) {
		return n;
	}
}
