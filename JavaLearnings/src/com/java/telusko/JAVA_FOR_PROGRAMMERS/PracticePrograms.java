package com.java.telusko.JAVA_FOR_PROGRAMMERS;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public  class PracticePrograms {
	
	public static void weakStrongHashMap() {
		
		WeakHashMap<Integer, Integer> weakMap = new WeakHashMap<>();
		Integer key1 = new Integer(1);
		Integer key2 = new Integer(20);
		
	

		weakMap.put(key1, 3);
		weakMap.put(key2, 20);
		
		System.out.println(weakMap);
		key1 =null;
		System.gc();
		
		System.out.println(weakMap);


	}
	
	public static void swapingNumWithoutTempVar(){

		int a= 871;
		int b= 53;
		
		a = a+b;
		b = a-b;
		a = a-b;
		System.out.println("a ="+a +" b ="+b);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float f = 1.23f;
		int a =6;
		Integer  i = a;
		int h = i;
		
		switch (a) {
		case 1: 
			System.out.println("one");
			System.out.println("one");
			break;
		default:
			System.out.println("default");
		}
		
		//swapingNumWithoutTempVar();
		//bubbleSort();
		callBinarySearch();
	}

	
	private static void callBinarySearch() {
		int[] arr = {16, 19, 20, 23, 45, 56, 78, 90, 96, 100};  
		int findNum = 20;
		int indexFound = binarySearch(arr,0,arr.length-1,findNum);
		System.out.println("The given number is found at index "+indexFound);
	}

	private static int binarySearch(int[] arr,int beg,int end,int searchNum) {
		int mid = 0;
		if(end >= beg) {
			mid = (beg+end) /2;
			
			if(arr[mid] == searchNum) {
				return mid;
			}else if(searchNum < arr[mid]) {
				return binarySearch(arr, beg, mid-1, searchNum);
			}else {
				return binarySearch(arr, mid+1, end, searchNum);
			}
		}
		
		return -1;
	}
	
	

	public static void bubbleSort() {
		  int[] a = {10, 9, 7, 101, 23, 44, 12, 78, 34, 23};  
		  int temp=0;
		  
		  for(int i=0;i<a.length;i++) {
			  for(int j=0;j<a.length;j++) {
				  if(a[i]<a[j]) {
					  temp = a[i];
					  a[i] = a[j];
					  a[j] = temp;
				  }
			  }
		  }
		  
		  Arrays.stream(a).forEach(System.out::println);
	}
	
}
