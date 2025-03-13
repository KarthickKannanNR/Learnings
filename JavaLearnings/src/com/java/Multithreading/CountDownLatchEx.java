package com.java.Multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchEx {

	public static void main(String[] args) throws InterruptedException {
      CountDownLatch latch = new CountDownLatch(5);
		
		Thread  t = null;
		for(int i =0 ;i<5;i++) {
			t = new Thread(new Worker(latch));
			t.start();
		}
		System.out.println("Main thrread is waiting");
	    latch.await();
	    System.out.println("Main thread ends");

	}

}

class Worker implements Runnable{
	private CountDownLatch latch;
	
	public Worker(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName());
		latch.countDown();
	}
	
	
}
