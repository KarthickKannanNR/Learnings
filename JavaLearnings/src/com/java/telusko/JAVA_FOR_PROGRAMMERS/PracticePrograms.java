package com.java.telusko.JAVA_FOR_PROGRAMMERS;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public  class PracticePrograms {
	
	public static void weakStrongHashMap() {
		
		WeakHashMap<Integer, Integer> weakMap = new WeakHashMap<>();
		Integer key1 = new Integer(1);
		Integer key2 = new Integer(20);
		
	

		weakMap.put(key1, 3);
		weakMap.put(key2, 20);
		
		System.out.println(weakMap);
		key1 =null;
		System.gc();
		
		System.out.println(weakMap);


	}
	
	public static void swapingNumWithoutTempVar(){

		int a= 871;
		int b= 53;
		
		a = a+b;
		b = a-b;
		a = a-b;
		System.out.println("a ="+a +" b ="+b);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float f = 1.23f;
		int a =6;
		Integer  i = a;
		int h = i;
		
		switch (a) {
		case 1: 
			System.out.println("one");
			System.out.println("one");
			break;
		default:
			System.out.println("default");
		}
		
		swapingNumWithoutTempVar();
	}

}
