package com.java.Multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class CompletebleFuture {
	
	private static Object object = new Object();
	private static IntPredicate evenPredicate = n ->n%2==0;
	private static IntPredicate oddPredicate = n ->n%2!=0;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		thenComposeEx();
		
	}
	
	public static void runAsync() {
		CompletableFuture<Void> runnable = CompletableFuture.runAsync(()->{
			                                  try {
												Thread.sleep(2000);
											} catch (InterruptedException e) {
												e.printStackTrace();
											}
			                                  System.out.println("without returning");
		                                   });
		//runnable.join();
		System.out.println("run async completed");
	}
	
	public static void supplyAsync() {
		CompletableFuture.supplyAsync(() ->{
			return 5;
		}).thenAccept((num) -> System.out.println(num*2));
	}
	
	public static void thenApplyEx() {
		CompletableFuture.supplyAsync(()->{
			return 5;
		}).thenApply(num -> num*2)
		  .thenApply(num -> num*5)
		  .thenAccept(total -> System.out.println(total));
	}
	
	public static void thenApplyReturn() throws InterruptedException, ExecutionException {
		CompletableFuture<Integer> total = CompletableFuture.supplyAsync(() -> {
			return 5;
		}).thenApply(num -> num * 2)
		  .thenApply(num -> num * 5);
		
		System.out.println(total.get());
	}
	
	public static void printNums() throws InterruptedException {
		CompletableFuture.runAsync(()->CompletebleFuture.printNums(evenPredicate));
		CompletableFuture.runAsync(()->CompletebleFuture.printNums(oddPredicate));
		Thread.sleep(1000);
		System.out.println("main thread ended");
	}
	
	public static void thenComposeEx() throws InterruptedException, ExecutionException {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			try {
				System.out.println("reached first future");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Data from API";
			}).thenCompose(data -> CompletableFuture.supplyAsync(() -> {
				System.out.println("reached second future "+data);
				return data + " processed";
			}));
		System.out.println(future.get());
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
