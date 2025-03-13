package com.java.Multithreading;

import java.util.Date;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockEx {
	private int sharedVariable = 0;
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	
	public void reader1() {
		lock.readLock().lock();
		System.out.println(Thread.currentThread().getName() +" "+new Date(System.currentTimeMillis())+sharedVariable);
		lock.readLock().unlock();
	}
	public void reader2() {
		lock.readLock().lock();
		System.out.println(Thread.currentThread().getName() +" "+new Date(System.currentTimeMillis())+sharedVariable);
		lock.readLock().unlock();
	}
	
	public void writer1() {
		lock.writeLock().lock();
		sharedVariable = 1;
		System.out.println(Thread.currentThread().getName() +" "+new Date(System.currentTimeMillis())+sharedVariable);
		//try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		lock.writeLock().unlock();
	}
	public static void main(String[] args) {
		ReadWriteLockEx obj = new ReadWriteLockEx();
		
		Thread t1 = new Thread(()-> {
			obj.reader1();
		},"Reader-Thread-1");
		
		Thread t2 = new Thread(()-> {
			obj.reader1();
		},"Reader-Thread-2");
		
		Thread t3 = new Thread(()-> {
			obj.writer1();
		},"Writer-Thread-1");
		
		t3.start();
		t1.start();
		t2.start();
	}

}
