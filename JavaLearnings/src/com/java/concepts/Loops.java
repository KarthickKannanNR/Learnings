package com.java.concepts;

import java.io.NotSerializableException;

public class Loops {
	Integer i;

	public Loops() {
		System.out.println("defaut constructor");
		
	}
	
	public static void loopConcepts() {
		int var =1;
		int j = 0;
		for(;;) {
			if(var>10) break;
			System.out.println(var);
			var++;
		}
	}
	
	public static void castingCheck() {
		//boolean can't be cast , we get a compilation error
//		String s = "false";
//		boolean n = (boolean) s;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		loopConcepts();
		new Loops().printInstanceVar();
	}
	
	public void printInstanceVar() {
		System.out.println(i);
	}

	
	
}
