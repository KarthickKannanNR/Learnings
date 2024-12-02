package com.java.interview.questions;

import java.security.KeyStore.Entry;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class StaticCheck{
	static {
		System.out.println("Static check static block");
	}
}

public class WithOutMainMethod extends Thread{
	/*
	 * static { System.out.println("Static block"); }
	 */
   
   
   public static void main(String[] args) {
	   int num = 123;
       ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
       map.put(1, "value"); // This will throw NullPointerException
       map.put(2, "value"); // This will throw NullPointerException
       map.put(3, "value"); // This will throw NullPointerException
       map.put(4, "value"); // This will throw NullPointerException
       
       for(Map.Entry<Integer, String> e:map.entrySet()) {
    	   System.out.println(e.getKey() +" "+e.getValue());
    	   map.put(5, "value");
       }
	   StaticCheck s = new StaticCheck();
	   
	   Integer a = 1;  // Autoboxing from int to Integer
	   int b = a; 
	   Integer c = null;  // Autoboxing from int to Integer

	   float f = 1.1f;
	   
	   b=(int) f;
	   System.out.println(b);
  }
   
   public WithOutMainMethod() {
           super();
   }
}
