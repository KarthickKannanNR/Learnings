package com.java8.staticMethods;

public class Derived extends Base{
	
	 public void set(int a)
	    {
	        this.a = a;
	    }

	    final public void get()
	    {
	        System.out.println("a = " + a);
	    }

		@Override
		public void set() {
			System.out.println("base class");
			
		}
}
