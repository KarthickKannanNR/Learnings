package com.java.learnings.java8;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class PrintOddEven {

	public static void main(String[] args) {
		CompletableFuture.runAsync(()->PrintOddEven.print(evenPredicate));
		CompletableFuture.runAsync(()->PrintOddEven.print(oddPredicate));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	} 
	private static Object object = new Object();
	private static IntPredicate evenPredicate = i -> i%2 == 0;
	private static IntPredicate oddPredicate = i -> i%2 != 0;

	public static void print(IntPredicate predicate) {
		
		IntStream.rangeClosed(1, 10).filter(predicate).forEach(PrintOddEven::execute);
	}
	
	public static void execute(int i) {
		synchronized(object) {
			System.out.println("Thread name : " + Thread.currentThread().getName() + " Value "+i);
			object.notify();
			try {
				object.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
