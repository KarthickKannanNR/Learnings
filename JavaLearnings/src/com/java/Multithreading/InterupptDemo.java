package com.java.Multithreading;

import com.java.Multithreading.InterupptDemo.MemberClass;

public class InterupptDemo {
	
	
	public class MemberClass{
		 int num;
	}
 
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Thread t = new Thread (()->{
			try {
				System.out.println("sleep started");
				Thread.sleep(5000);
				System.out.println("sleep ended");
				Thread.currentThread().interrupt();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		InterupptDemo.MemberClass memberClass = new InterupptDemo().new MemberClass();
		InterupptDemo obj1 = new InterupptDemo();
		InterupptDemo obj2 = obj1;
		t.start();
		Thread.sleep(2000);
		//t.interrupt();
		while(!t.isInterrupted())
			System.out.println("thread interuppted");
		
		System.out.println("main thread ends");
	}

}
