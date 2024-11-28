package com.java.interview.questions;

class StaticCheck{
	static {
		System.out.println("Static check static block");
	}
}

public class WithOutMainMethod {
   static {
	   System.out.println("Static block");
   }
   
   
   public static void main(String[] args) {
	
	   StaticCheck s = new StaticCheck();
  }
}
