package com.java.interview.questions;

public class CustomLinkedList<T> {
	Node<T> head;
	Node<T> tail;
	
	 class Node<T>{
		T data;
		Node<T> next;
		Node<T> prev;
		Node(T data){
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
	
	public void add(T data) {
		Node<T> newNode = new Node<>(data);
		if(head == null) {
			head = tail = newNode;
		}else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}
	
	public void addFirst(T data) {
		Node<T> newNode = new Node<>(data);
		if(head==null) {
			head = tail = newNode;
		}else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}
	
	public void add(int index,T data) {
		Node<T> newNode = new Node<>(data);
		Node<T> temp = head;
		if(temp ==null) return;
		int i=0;
		while(temp.next != null && i<index) {
			  temp = temp.next;
			  i++;
		}
		if(i<index) throw new IndexOutOfBoundsException("Index "+index +" is out of bound");
		Node<T> prev = temp.prev;
		prev.next = newNode;
		newNode.prev = prev;
		newNode.next = temp;
		temp.prev = newNode;
		if(index==0) {
			head = newNode;
		}
	}
	
	public void reverse() {
		Node<T> temp = null;
		Node<T> current= head;
			while(current!=null) {
				temp =  current.prev;
				current.prev = current.next;
				current.next = temp;
				current = current.prev;
			}
			if(temp!=null) {
				head = temp.prev;
			}
	}
	
	public  void print() {
		Node<T> temp = head;
		if(temp!=null) {
			while(temp!=null) {
				System.out.println(temp.data+" ");
				temp = temp.next;
			}
		}else {
			System.out.println("[]");
		}
		
	}
	
	
}
