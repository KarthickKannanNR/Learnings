package com.java.concepts;

class X {
	static int i = 1111;
	int num =0;
	static {
		i = i-- - --i; // L1
	}

	{
		i = i++ + ++i; // L2
		num =10;
	}
	
	X(int num){
		this.num =num;
	}
}

class Y extends X {
	
	Y(int num) {
		super(num);
		// TODO Auto-generated constructor stub
	}

	static {
		i = --i - i--; // L3
		{
			i = ++i + i++; // L4
		}
	}

	{
		i = ++i + i++; // L4
	}
}

public class DriverClass {
	public static void main(String[] args) {

		Y y = new Y(20);
		System.out.println(y.i); // L5

		Y y2 = new Y(30);
		System.out.println(y.i);
		
		System.out.println(y.num);
		System.out.println(y2.num);

	}
}
