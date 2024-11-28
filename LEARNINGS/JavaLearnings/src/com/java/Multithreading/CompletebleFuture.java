package com.java.Multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class CompletebleFuture {
	
	private static Object object = new Object();
	private static IntPredicate evenPredicate = n ->n%2==0;
	private static IntPredicate oddPredicate = n ->n%2!=0;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		CompletableFuture.runAsync(()->CompletebleFuture.printNums(evenPredicate));
		CompletableFuture.runAsync(()->CompletebleFuture.printNums(evenPredicate));
		Thread.sleep(1000);

	}
	
	public static void printNums(IntPredicate condition) {
		IntStream.rangeClosed(1, 10).filter(condition).forEach(CompletebleFuture::execute);
	}
	
	public static void execute(int num) {
		synchronized (object) {
			try {
				System.out.println(Thread.currentThread().getName()+" : "+num);
				object.notify();
				object.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
