package com.java.datastructures_and_algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DSA_PRACTICE {
	
	public static void binaryRep() {
		int num =80;
		String binaryString  = Integer.toBinaryString(num);
		System.out.println(binaryString);
	}
	
	
	public static void stack() {
		Stack<String> names = new Stack<>();
		names.push("karthick");
		names.push("akash");
		names.push("alamelu");
		names.push("raja jegatheesh");
		
	    System.out.println(names.peek()); 
	    System.out.println(names);
	}
	
	
	public static void queue() {
		
		Queue<String> queue = new LinkedList<>();

		queue.add("karthick");
		queue.add("akash");
		queue.add("alamelu");
		queue.add("raja jegatheesh");
		
		System.out.println(queue);
		System.out.println("peek :"+queue.peek());
	}

	public static void linkedList() {
		LinkedList<String> ll = new LinkedList<>();
		ll.add(1,"kk");
		ll.add(2,"karthick");
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		binaryRep();	    
	}

}
