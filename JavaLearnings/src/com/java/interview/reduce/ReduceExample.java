package com.java.interview.reduce;

import java.util.Arrays;
import java.util.List;

public class ReduceExample {
	 protected int num =10;
	
	public static void reduce(int i) {
		
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8);
		System.out.println("Add "+nums.stream().reduce(0,(sum,list)-> sum+list));
		System.out.println("multiply "+nums.stream().reduce(1,(sum,list)-> sum*list));

		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reduce(8);
	}

}
