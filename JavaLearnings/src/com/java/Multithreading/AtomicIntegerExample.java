package com.java.Multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
	static  int n =0;

    public static void main(String[] args) {
        AtomicInteger atomicInt = new AtomicInteger(0);

        // Create multiple threads to increment the AtomicInteger
        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
            	//n =n+1;
            	System.out.println(Thread.currentThread().getName());
                atomicInt.incrementAndGet(); // Atomically increments the value
            }
        };

        Thread thread1 = new Thread(incrementTask,"thread1");
        Thread thread2 = new Thread(incrementTask,"thread2");
        thread1.start();
        thread2.start();

        // Wait for threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display the final value
        System.out.println("Final value: " + atomicInt.get());
        //System.out.println(n);
    }
}
