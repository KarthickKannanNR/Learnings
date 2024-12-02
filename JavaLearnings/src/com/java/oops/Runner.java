package com.java.oops;

import java.util.Currency;
import java.util.concurrent.atomic.AtomicInteger;

public class Runner{
	static Object lockObject = new Object();
	 AtomicInteger num= new AtomicInteger(0);
	 int kjuytf;

	Runner(){
		System.out.println("Runner constructor called");
	}
	
	public void increment() {
		
		num.incrementAndGet();
	}
			
	public AtomicInteger getCounter() {
        return num;
    }
	
	public static void main(String[] args) {
		/*
		 * Implementor impl = new Implementor(); impl.print();
		 * impl.printFromAbstractClass(); impl.add(2, 3);
		 */
		Runner runner = new Runner();
		Runner runner2 = new Runner();

		Thread t1 = new Thread(()->{
			for(int i=0;i<1000;i++) {
				runner.increment();
			}
		});
		
		Thread t2 = new Thread(()->{
			for(int i=0;i<1000;i++) {
				runner.increment();
			}
		});
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(runner.num);
	}

}
