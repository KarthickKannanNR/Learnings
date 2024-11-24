package com.java8.defaultmethod;

public class Class1 implements Interface1,Interface2{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interface1 clas = new Class1();
		clas.eat();
		

	}

	public void eat() {
		// TODO Auto-generated method stub
		//Interface1.super.eat();
		//or
		//Interface2.super.eat();
		//or
		//Interface1.super.eat();
		//Interface2.super.eat();
		// or
		
		System.out.println("i took my own decision");
	}

}
