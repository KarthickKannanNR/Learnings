package com.java.oops.overloading;

public class OverloadingConcepts {
	
	  void sum(int a,long b){System.out.println("a method invoked");}    
	  void sum(long a,int b){System.out.println("b method invoked");}    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OverloadingConcepts obj=new OverloadingConcepts();    
		//The method sum(int, long) is ambiguous for the type OverloadingConcepts
		//obj.sum(10, 10);
	}

}
