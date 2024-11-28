package com.java.syncronizedExample;

import java.util.function.Function;

class class1 implements Runnable{
	
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("cake1 : "+i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class class2 implements Runnable{
	
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("cake2 : "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class ThreadBaking {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new class1());
		t1.setName("thread 1");
		t1.setPriority(10);
		t1.start(); 
		System.out.println(t1.getName()+t1.isAlive());
		Thread t2 = new Thread(new class2());
		t2.start();
		t2.setName("thread 2");
		t1.setPriority(5);

		System.out.println(t2.isAlive());
		System.out.println(t2.getName()+t1.isAlive());
		t1.join();
		
		System.out.println(t1.isAlive());
		System.out.println(t2.isAlive());
		System.out.println("thread ended");
	}
}
