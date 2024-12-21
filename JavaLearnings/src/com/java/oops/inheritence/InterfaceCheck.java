package com.java.oops.inheritence;


interface InterfaceA{
   public default void print() {
	   System.out.println("InterfaceA print");
   }
}

interface InterfaceB{
	public default void print() {
		System.out.println("InterfaceB print");
	}
}

class SubClass implements InterfaceA,InterfaceB{

	@Override
	public void print() {
		InterfaceA.super.print();
		InterfaceB.super.print();
	}
	
}

public class InterfaceCheck {

	public static void main(String[] args) {
		SubClass s = new SubClass();
		s.print();
		
	}

}
