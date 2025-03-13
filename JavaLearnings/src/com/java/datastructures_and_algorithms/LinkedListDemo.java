package com.java.datastructures_and_algorithms;

import java.util.ArrayList;
import java.util.Iterator;

public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * LinkedList list = new LinkedList(); list.insertAtBeginning(5);
		 * list.insertAtBeginning(10); list.insertAtBeginning(11);
		 * list.insertAtPos(3,7); list.insertAtPos(4,87); list.display();
		 * list.delete(3); System.out.println("after delete"); list.display();
		 */

		/*
		 * DoublyLinkedList<Integer> lk = new DoublyLinkedList<>();
		 * lk.insertAtBeginning(5); lk.insertAtBeginning(10); lk.insertAtBeginning(11);
		 * lk.display(); lk.insertAtPos(3, 13); System.out.println(); lk.display();
		 */

		// linkedList practice 2
		/*
		 * LinkedList<Integer> list = new LinkedList<>(); list.add(null); list.add(6);
		 * list.add(7); list.add(8); list.add(9); list.add(10); list.add(11);
		 * 
		 * System.out.println(list.get(4)); list.add(2, 20);
		 * System.out.println(list.size());
		 * 
		 * // custom iterator Iterator<Integer> customIterator = list.iterator();
		 * System.out.println("custom Iterator"); while (customIterator.hasNext()) {
		 * System.out.println(customIterator.next()); }
		 * 
		 * list.remove(); System.out.println("after remove : "+ list.size());
		 * 
		 * Iterator<Integer> customIterator2 = list.iterator(); while
		 * (customIterator2.hasNext()) { System.out.println(customIterator.next()); }
		 * 
		 * 
		 * java.util.LinkedList<Integer> list2 = new java.util.LinkedList<>();
		 * list2.add(11); list2.add(12); list2.add(1,13); Iterator<Integer>
		 * list2Iterator = list2.iterator(); while(list2Iterator.hasNext()) {
		 * System.out.println(list2Iterator.next()); }
		 * 
		 * while(list2Iterator.hasNext()) { System.out.println(list2Iterator.next()); }
		 */
		 reverseList();	
	}

	private static void reverseList() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.insertAtBeginning(5);
		list.insertAtBeginning(4);
		list.insertAtBeginning(3);
		list.insertAtBeginning(2);
		list.insertAtBeginning(1);
		
		list.display();
		list.reverseList();
		System.out.println();
		list.display();
	}

}
