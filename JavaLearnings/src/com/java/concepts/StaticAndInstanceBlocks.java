package com.java.concepts;

public class StaticAndInstanceBlocks {
    static int num =0;
	
	static {
		System.out.println("static block called");
		num +=10;
	}
	
	{
		System.out.println("Instance block called");
		num +=20;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * StaticAndInstanceBlocks obj = new StaticAndInstanceBlocks();
		 * System.out.println(num); StaticAndInstanceBlocks obj2 = new
		 * StaticAndInstanceBlocks(); System.out.println(num);
		 */
		
		Child c = new Child();
		System.out.println(num);
	}

}

class Child extends StaticAndInstanceBlocks{
	static {
		num += 5;
	}
	
	{
		num += 1;
	}
}
