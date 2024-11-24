package com.java.Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		List<Integer> numlist = new ArrayList<>();
		
		ForkJoinPool fj = new ForkJoinPool(20);
		
		for(int i=0;i<10;i++) 
			numlist.add(i);
		
		long initialTime = System.currentTimeMillis();
		
		Thread t1 =  new Thread(() ->{
			fj.submit(() ->numlist.parallelStream().forEach(a->{
				try {
					Thread.sleep(100);
					System.out.println(Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			})).invoke();
		});
		t1.start();
		t1.join();
		/*
		 * numlist.parallelStream().forEach(l ->{ try {
		 * System.out.println(Thread.currentThread().getName()); Thread.sleep(100); }
		 * catch (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } });
		 */
		
		long endTime = System.currentTimeMillis();
		System.out.println("Difference : "+ (endTime-initialTime));
	}

}
