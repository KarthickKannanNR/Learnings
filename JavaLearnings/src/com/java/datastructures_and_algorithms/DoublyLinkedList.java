package com.java.datastructures_and_algorithms;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterator<T> {
	Node head;
	Node tail;
	class Node{
		int data;
		Node next;
		Node prev;
		Node(int data){
			this.data = data;
			next = null;
			prev = null;
		}
	} 
	
	DoublyLinkedList(){
		head = null;
		tail = null;
	}

	public void insertAtBeginning(int data) { 
		// TODO Auto-generated method stub
	   Node newNode = new Node(data);
  	   newNode.next = head;
	   	if(head == null) {
	   		tail = newNode;
	   	}else {
	   		head.prev = newNode;
	   	}
   		head = newNode;
	}
	
	public void display() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	public void displayRev() {
		Node temp = tail;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.prev;
		}
	}

	public void insertAtPos(int pos,int val) {
		if(pos ==0) {
			insertAtBeginning(val);
			return;
		}
		Node newNode = new Node(val);
		Node temp = head;
		for(int i=1;i<pos;i++) {
			if(temp==null) {
				throw new IndexOutOfBoundsException("no position found");
			}
			temp = temp.next;
		}
		newNode.next = temp.next;
		newNode.prev = temp;

		if(temp==tail) {
			tail = newNode;
		}else {
			temp.next.prev = newNode;
			temp.next = newNode;	
		}

	}
	
	public int get(int pos) {
		int result = 0;
		Node temp = head;
		for(int i=0;i<=pos;i++) {
			if(i==pos) {
				result = temp.data;
				break;
			}
			temp = temp.next;
		}
		return result;
	}
	
	public void delete(int pos) {
		if(head ==null) {
			throw new IndexOutOfBoundsException("List is empty");
		}else if(pos ==0) {
			head = head.next;
			return;
		}
		Node prev = null;
		Node temp = head;
		for(int i=0;i<pos;i++) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = temp.next;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void reverseList() {
		Node curr = head;
		Node temp = null;
		
		while(curr != null) {
			temp = curr.prev;
			curr.prev = curr.next;
			curr.next = temp;
			curr = curr.prev;
		}
		if(temp!=null) {
			head = temp.prev;	
		}
	}
	
}
