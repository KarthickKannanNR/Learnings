package com.java.datastructures_and_algorithms;

public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		LinkedList list =  new LinkedList();
//		list.insertAtBeginning(5);
//		list.insertAtBeginning(10);
//		list.insertAtBeginning(11);
//		list.insertAtPos(3,7);
//		list.insertAtPos(4,87);		
//		list.display();
//		list.delete(3);
//		System.out.println("after delete");
//		list.display();
		
		
		DoublyLinkedList<Integer> lk = new DoublyLinkedList<>();
		lk.insertAtBeginning(5);
		lk.insertAtBeginning(10);
		lk.insertAtBeginning(11);
		lk.display();
		lk.insertAtPos(3, 13);
		System.out.println();
		lk.display();

	}

}
