package com.java.datastructures_and_algorithms;

import java.util.Iterator;
import java.util.LinkedList;

public class ArrayListChkMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArrayList<Integer> list = new ArrayList<>();
		System.out.println("size : "+list.size());
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);

		System.out.println("size : "+list.size());
		//list.remove(5);
		System.out.println("size : "+list.size());
		
		
		Iterator<Integer> customIterator = list.iterator();
		while(customIterator.hasNext()) {
			System.out.println(customIterator.next());
			//customIterator.remove();
		}

		System.out.println("size : "+list.size());
		list.add(8);
		Iterator<Integer> customIterator2 = list.iterator();
		while(customIterator2.hasNext()) {
			System.out.println(customIterator2.next());
			//customIterator2.remove();
		}
		System.out.println("size : "+list.size());
		
		
		java.util.ArrayList<Integer> list2 = new java.util.ArrayList<>();
		list2.add(2);
	
	}

}
