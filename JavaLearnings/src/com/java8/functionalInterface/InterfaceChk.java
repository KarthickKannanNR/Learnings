package com.java8.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class InterfaceChk {

	static ReentrantLock lock = new ReentrantLock();
	static int num = 0;
	public static void main(String[] args){
		// TODO Auto-generated method stub
	
		
		Thread t1 = new Thread(()->accessResource());
		Thread t2 = new Thread(()->accessResource());
		Thread t3 = new Thread(()->accessResource());
		Thread t4 = new Thread(()->accessResource());
		 		
		t1.start();
		t2.start();
		t3.start(); 
		t4.start();
		System.out.println(num);

	}

	private static void accessResource(){
		lock.lock();

         num++;
         System.out.println(num);
         System.out.println(lock.getHoldCount());
		Car.print();
         try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         lock.unlock();
 

	}
}
