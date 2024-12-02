package com.java.threadPractice;

import java.util.concurrent.locks.ReentrantLock;

class IncreaseCount implements Runnable{
	volatile int count=0;
	boolean increasedCountFlag= false;
	Object lockObj = new Object();
	ReentrantLock lock = new ReentrantLock(true);
	
	

	@Override
	public void run() {
		
		//synchronized (lockObj) {
		/*
		 * while(this.increasedCountFlag) { try { //lockObj.wait(); increasedCountFlag=
		 * true; } catch (Exception e) { e.printStackTrace(); } }
		 */
		    //lock.lock();
			this.count+=1;
			System.out.println(count);
			System.out.println("Count Increased by Thread : " + Thread.currentThread().getName());
			//lock.unlock();
			//increasedCountFlag= true;
			//lockObj.notify();
		//}
		
		
		
	}
	
}

public class IncreaseCountByMultipleThreads {

	public static void main(String[] args) throws InterruptedException {
		IncreaseCount obj  = new IncreaseCount();
		for(int i=1;i<=200;i++) {
			new Thread(obj).start();
		}
		Thread.sleep(2000);
		System.out.println("total : "+obj.count);
	}

}
