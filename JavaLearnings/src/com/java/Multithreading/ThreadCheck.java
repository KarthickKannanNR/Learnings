package com.java.Multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadCheck extends Thread{

	public ThreadCheck(String threadName){
		super(threadName);
	}
	
	static Integer lock = new Integer(1);
	int count = 0;
	 ReentrantLock reLock = new ReentrantLock();
	
	@Override
	public void run() {
		//synchronized (lock) {
			count++;
			try {
				this.interrupt();
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Thread.currentThread().yield();
			System.out.println(Thread.currentThread().getName());
			System.out.println(count);
			
		//}
		//reLock.lock();
		//count++;
		//reLock.unlock();
	}
	
	 public static synchronized void method() throws InterruptedException {
		lock.wait();
	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadCheck t = new ThreadCheck("dummmy");
		Thread thread = null;
		for(int i =0;i<1000;i++) {
			thread = new Thread(t);
			thread.start();
		}
		Thread.currentThread().sleep(4000);
		thread.interrupt();
		thread.currentThread().wait();
		System.out.println("main method ends");
	}
}
