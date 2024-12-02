package com.java.interview.questions;

import java.util.ArrayList;
import java.util.List;

public class CallByValueAdReferece {

	 int i;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numList = new ArrayList<>();
		numList.add(1);
		setValue(numList);
		System.out.println(numList);
		
		CallByValueAdReferece obj = new CallByValueAdReferece();
		obj.i= 10;
		obj.set();
		System.out.println(obj.i);
		
		CallByValueAdReferece obj2 = new CallByValueAdReferece();
		obj2.i = 100;
		obj2.set();
		System.out.println(obj2.i);

	}
	
	public static void setValue(List<Integer> numList) {
		numList.add(2);
	}
	
	public void set() {
		this.i=11;
	}

}
