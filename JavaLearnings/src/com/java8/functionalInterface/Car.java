package com.java8.functionalInterface;

@FunctionalInterface 
public interface Car extends  Vehicle{

	
	
	static void print() {
		System.out.println("from functional interface "+Vehicle.i);
	}
	
}
