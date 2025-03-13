package com.java.interview.questions;

public class CustomLinkedListTest {

	public static void main(String[] args) {
		CustomLinkedList<Integer> list = new CustomLinkedList<>();
		list.add(5);
		list.add(3);
		list.add(1);
		list.add(0,10);
		list.add(8);
		list.print();
	}

}
