package com.java.datastructures_and_algorithms;

import java.util.Iterator;
import java.util.Stack;

public class StackEx {

	public static void main(String[] args) {
		Stack<Integer> nums = new Stack<>();
		nums.push(1);
		nums.push(2);
		nums.push(3);
		nums.push(4);
		nums.push(5);
		
		Stack<Integer> nums2 =  (Stack<Integer>) nums.clone();
		while(!nums.isEmpty()) {
			System.out.println(nums.pop());
		}
	}

}
