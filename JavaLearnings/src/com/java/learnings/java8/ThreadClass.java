package com.java.learnings.java8;

import java.util.ArrayList;
import java.util.List;

public class ThreadClass extends Thread{

	@Override
	public void run() {
		/*
		 * for(int i=0;i<100;i++) { System.out.println(i); }
		 */
	}
	
	public static void main(String[] args) {
		ThreadClass t = new ThreadClass();
		t.start();
		System.out.println("main method ends");
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1,7676);
		list.remove(1);
		System.out.println(list);

		
	}

	private static int getArrayListCapacity(ArrayList<?> list) {
        try {
            // Access private 'elementData' field (internal array)
            return ((Object[]) list.getClass().getDeclaredField("elementData").get(list)).length;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
