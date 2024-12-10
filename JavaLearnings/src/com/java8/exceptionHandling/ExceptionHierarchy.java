package com.java8.exceptionHandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

class Parent{
	public Parent() throws IOException{
		System.out.println("parent constructor called");
	}
	
	public void add() throws CloneNotSupportedException{
		
	}
}

class Child extends Parent{
	public Child() throws IOException {
		System.out.println("child constructor called");
		FileInputStream fis = new FileInputStream("z//adfaf");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
	}
	
	@Override
     public void add() throws CloneNotSupportedException{
		
	}
}


public class ExceptionHierarchy {
	
	public static final void main(String[] args){
		//Parent p = new Child();
		/*
		 * try { badMethod(); } catch (Exception e) { e.printStackTrace(); }finally{
		 * System.out.println("from main method finally block"); }
		 * 
		 * 
		 */
		checkImmutabliity();
		try {
			System.out.println("main method try");
		} catch (ExceptionInInitializerError e) {
			System.out.println("main method catch");
			e.printStackTrace();
		}
	}
	
	private static void badMethod(){
		throw new IndexOutOfBoundsException("bad method error");
	}

	
	public static void checkImmutabliity() {
		final int  i;
		System.out.println(i=30);
		System.out.println(i);
		
		Integer n = 10;
		n = 20;
		System.out.println(n);
		//Double d = 10.5;
		//Integer i = Integer.parseInt(d.toString());
		//System.out.println(i);
	}
}
