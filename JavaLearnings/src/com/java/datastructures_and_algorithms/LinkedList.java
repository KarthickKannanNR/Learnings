package com.java.datastructures_and_algorithms;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>{

	private Node<T> head;
	private Node<T> tail;
	private int size;
	private int iteratorIndex;
	private Node<T> currNode;
	
	@Override
	public Iterator<T> iterator() {
		currNode = head;
		return new CustomIterator();
	}
	
	private class CustomIterator<T> implements Iterator<T>{
		public CustomIterator() {
			iteratorIndex = 0;
		}

		@Override
		public boolean hasNext() {
			if(iteratorIndex == size) {
				currNode =  null;
			}
			return iteratorIndex < size;
		}

		@Override
		public T next() {
			if(iteratorIndex !=0) {
				currNode = currNode.next;
			}
			iteratorIndex++;
			return (T) currNode.data;
		}
	}
	
	@Override
	public String toString() {
		return "LinkedList [head=" + head + ", tail=" + tail + ", size=" + size + "]";
	}


	public LinkedList() {
		this.head = null;
		this.tail = null;
	}
		
	
	 class Node<T>{
		T data;
		Node<T> next;
		Node<T> prev;
		
		Node(T data){
			this.data = data;
			next = null;
			prev = null;
		}
	}
	
	
	public void add(T data) {
		Node<T> newNode = new Node<T>(data);
		
		if(head == null) {
			head = newNode;
			tail = newNode;
		}else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		size++;
	}
	
	public void add(int index,T data) {
		Node<T> newNode = new Node<T>(data);
		
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: "+index + " size: " +size);
		}
		int i =0;
		Node<T> currIndexNode = head;
		while(i < index) {
			currIndexNode = currIndexNode.next;
			i++;
		}
		Node<T> tempNode = currIndexNode.prev;
		tempNode.next = newNode;
		currIndexNode.prev = newNode;
		newNode.next = currIndexNode;
		newNode.prev = tempNode;
		if (tail == newNode) {
			tail = newNode;
		}
		size++;
	}


	public T get(int index) {
		
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index: "+index + " size: " +size);
		}
		if(index == 0) {
			return head.data;
		}
		Node<T> returnNode = head.next;
		int i=1;
		while(i<index) {
			returnNode = returnNode.next;
			i++;
		}
		return returnNode.data;
	}
	
	public int size() {
		return size;
	}


	public void remove() {
		if(size == 0) {
			System.out.println("List is empty");
		}else {
			Node currNode = head;
			Node nextNode = currNode;
			while(nextNode != null) {
				currNode = nextNode;
				nextNode = nextNode.next;
				currNode = null;
				size--;
			}
			head =null;
			tail = null;
			currNode = null;
		}
	}
	
	/*
	 * public void remove(int index) { if(index >= size || index < 0) { throw new
	 * IndexOutOfBoundsException("Index: "+index + " size: " +size); } if(head ==
	 * null) { System.out.println("list is empty"); return; } Node current = head;
	 * int count = 0; while(count < index) { current = current.next; count++; }
	 * 
	 * if(current == head) { head = head.next; head.prev = null; }else if(current ==
	 * tail) {
	 * 
	 * }
	 * 
	 * 
	 * 
	 * }
	 */

}
