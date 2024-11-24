package com.java8.staticMethods;

public abstract  class Base {

	 public static void show() {
	       System.out.println("Base::show() called");
	 }
	 public int a;
	     Base()
	    {
	        a = 10;
	    }

	    abstract public void set();
	    
	    abstract  public void get();
}
