package com.java.datastructures_and_algorithms;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class ArrayList<T> implements Iterable<T>{

	private Object []elements;
	private int size;
	public static final int INITIAL_CAPACITY = 10;
	private int modCount = 0;

	ArrayList(){
		elements = new Object[INITIAL_CAPACITY];
		size = 0;
	}
	
	public void add(T element) {
		if(modCount > 0) {
			modCount =0;
			throw new ConcurrentModificationException();
		}else if(size == elements.length) {
			resize();
		}
		elements[size++] = element;
	}
	
	private void resize() {
		int newCapacity = INITIAL_CAPACITY * 2;
		elements = Arrays.copyOf(elements, newCapacity);
	}
	
	public int size() {
		return size;
	}
	
	public T get(int index) {
		if(index > size || index < 1) {
			throw new IndexOutOfBoundsException("List Actual size is : "+size +", But requested for the value in index : "+index);
		}
		return (T) elements[index];
	}
	
	
	public void set(int index, T value) {
		if(index > size || index < 1) {
			throw new IndexOutOfBoundsException("List Actual size is : "+size +", But trying to add the value in index : "+index);
		}
		elements[index] = value;
	}
	
	// remove an element at specific index
	public void remove(int index) {
		if(index > size || index < 1){
			throw new IndexOutOfBoundsException("List Actual size is : "+size +", But trying to remove the value in index : "+index);
		}
		
		//shifting remaining elements to left
		for(int i = index; i < size -1; i++) {
			elements[i] = elements[i+1];
		}
		
		//nullifying the last element
		elements[--size] = null;
		//size--;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ArrayListIterator();
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	private class ArrayListIterator implements Iterator<T>{
		private int currentIndex = 0;

		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			modCount++;
			return currentIndex < size;
		}

		@Override
		public T next() {
			if(!hasNext()) {
				throw new IllegalStateException();
			}
			
			return (T) elements[currentIndex++];
		}
		
		@Override
		public void remove() {
			if(currentIndex == 0) {
				throw new IllegalStateException();
			}
			
			for(int i = currentIndex-1;i < size -1;i++) {
				elements[i] = elements[i+1];
			}
			
			elements[--size] = null;
			currentIndex--;
			
		}
		
	}
}
