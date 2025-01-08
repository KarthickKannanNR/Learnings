package com.java.Multithreading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Supplier;

class ProducerBlockingQueue implements Runnable {
	private BlockingQueue<Integer> bq;

	ProducerBlockingQueue(BlockingQueue<Integer> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println("Produced " + i);
				bq.put(i);
				//Thread.currentThread().sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ConsumerBlockingQueue implements Runnable {

	private BlockingQueue<Integer> bq;

	ConsumerBlockingQueue(BlockingQueue<Integer> bq) {
		this.bq = bq;
	}

	Supplier<Integer> sup = () -> 0;

	public void run() {
		while (true) {
			try {
				Thread.currentThread().sleep(5000);
				System.out.println("Consumed " + bq.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (bq.isEmpty())
				break;
		}
	}
}

public class ProducerConsumerUsingBlockingQueue {

	public void check(int... nums) {
		
		
	}
	
	public static void main(String... args) {
		
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(2);
		
		new Thread(new ProducerBlockingQueue(bq)).start();
		new Thread(new ConsumerBlockingQueue(bq)).start();
			
	}

	

}
