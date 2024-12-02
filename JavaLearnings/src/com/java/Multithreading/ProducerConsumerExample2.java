package com.java.Multithreading;

import java.util.ArrayList;
import java.util.List;

class Calculate{
	int count = 0;
	boolean isValueSetted = false;
	public synchronized void produce(int num) {
		while(isValueSetted) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count = num;
		System.out.println(Thread.currentThread().getName().concat(" Produced :")+ count);
		isValueSetted=true;
		notify();
	}
	
	public synchronized void consume() {
		while(!isValueSetted) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName().concat(" Consumed :")+ count);
		isValueSetted =false;
		notify();
	}
}

class Producer implements Runnable{
    private Calculate c;
    Thread t;
    public Producer(Calculate c){
		this.c = c;
	     t = new Thread(this,"Producer Thread");

		t.start();

	}
	
	@Override
	public void run() {
		int i=0;
		while(true) {
			c.produce(i++);
			try {
				if(i==5) {
					break;
				}
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}

class Consumer implements Runnable{
	private Calculate c;
	Thread t;
	public Consumer(Calculate c){
		this.c = c;
		 t = new Thread(this,"Consumer Thread");

		t.start();
	}

	@Override
	public void run() {
		
		while(true) {
			c.consume();
			try {
				if(c.count==5) {
                    break;
				}
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

public class ProducerConsumerExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculate c = new Calculate();
		new Producer(c);
		new Consumer(c);
		List<Integer> hg = new ArrayList<>(2);
		hg.add(1);
		hg.add(2);
		hg.add(3);
		synchronized (c) {
			System.out.println("Wait method called");
			int processorCount = Runtime.getRuntime().availableProcessors();
			System.out.println(processorCount);
			try {
				c.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c.notifyAll();
			System.out.println("lock  released");
		}
	}

}
