package com.java.Multithreading;

public class Test {
	static int num = 10;
	static int total = print2();
	
	String name = "";
	
	public static void main(String[] args) {
		num = 5;
		int total = print2();
		print();
	}
	
	public static int print() {
		System.out.println(total);
       return 10;
    }
	
	public static int print2() {
		return 10 * 10;
	}
	
	public int add() {
		return 2;
	}

}
