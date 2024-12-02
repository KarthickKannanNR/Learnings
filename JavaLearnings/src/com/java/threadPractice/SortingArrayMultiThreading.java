package com.java.threadPractice;

import java.util.Arrays;



public class SortingArrayMultiThreading {
	
	private static final int ARRAY_SIZE = 10;
	private static final int NUMBER_OF_THREADS = 4;

	public static void main(String[] args) {
		
		int[] arr = createArray();
	    System.out.println("Before sorting: " + Arrays.toString(arr));
	    
	    Thread[] threads = new Thread[NUMBER_OF_THREADS]; 
	    int segments = ARRAY_SIZE/NUMBER_OF_THREADS;
	    
	    for(int i=0;i<NUMBER_OF_THREADS;i++) {
	    	int startIndex = i*segments;
	    	int endIndex = (i == ARRAY_SIZE-1)? ARRAY_SIZE-1:(startIndex + segments-1);
	    	threads[i] = new Thread(new SortTask(arr, startIndex, endIndex));
	    	threads[i].start();
	    }
	    for(Thread thread:threads) {
	    	try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    mergeSort(arr, 0, arr.length-1);
	    
	    Arrays.stream(arr).forEach(num -> System.out.print(num+", "));
	}
	
	private static void mergeSort(int []arr,int left,int right) {
		if(left < right) {
			int mid = (left+right) /2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			merge(arr,left,mid,right);
		}
	}
	
	private static void merge(int[] arr, int left, int mid, int right) {
		int[] temp = new int[right - left+1];
		int i = left,j=mid+1,k=0;
		
		while (i <= mid && j <= right) {
		      if (arr[i] <= arr[j]) {
		        temp[k++] = arr[i++];
		      } else {
		        temp[k++] = arr[j++];
		      }
		}
		
		while (i <= mid) {
		      temp[k++] = arr[i++];
		}

		while (j <= right) {
			temp[k++] = arr[j++];
		}
	    System.arraycopy(temp, 0, arr, left, temp.length);

	}

	private static int[] createArray() {
		int[] array = new int[ARRAY_SIZE];
		for (int i = 0; i < ARRAY_SIZE; i++) {
			array[i] = (int) (Math.random() * 400); // Generate random numbers between 0 and 400
		}
		return array;
	}

}

class SortTask implements Runnable{
	 
	private int[] array;
	private int startIndex;
	private int endIndex;
	
	public SortTask(int[] array,int startIndex,int endIndex) {
		this.array = array;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}
	
	@Override
	public void run() {
		Arrays.sort(array, startIndex, endIndex);
	}
	
}