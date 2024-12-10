package com.java.oops;

abstract class AbstractExample{
	abstract void print();
	public void printFromAbstractClass() {
		System.out.println("Print form abstract class");
	}
	
	public int add(int a,int b) {
		return a+b;
	}
	
	final void finalMethod() {
		System.out.println("final method from abstract method");
	}
	
	
}
