package com.java.ibs;

import java.util.Arrays;

public class PracticePrograms {

	public static void mergeAndSort() {
		int[] arr1 = new int[] { 4, 7, 1, 9, 1, 10, 45, 1 };
		int[] arr2 = new int[] { 64, 19, 27, 92, 41, 1 };
		int[] arr3 = new int[arr1.length + arr2.length];
		System.arraycopy(arr1, 0, arr3, 0, arr1.length);
		System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
		
		for(int num:arr3) {
			System.out.println(num);
		}
		
		int temp =0;
		for(int i=0;i<arr3.length;i++) {
			for(int j=i;j<arr3.length;j++) {
				if(arr3[i] > arr3[j]) {
					temp = arr3[j];
					arr3[j] = arr3[i];
					arr3[i] = temp;
				}
			}
		}
		
		System.out.println("after sorted");
		for(int num:arr3) {
			System.out.print(num+" ");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mergeAndSort();
	}

}
