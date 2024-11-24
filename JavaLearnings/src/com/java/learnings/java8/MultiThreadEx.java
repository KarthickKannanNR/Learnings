package com.java.learnings.java8;

public class MultiThreadEx implements Runnable {

	public MultiThreadEx(Object object) {
		super();
		this.object = object;
	}

	static int count = 1;
	Object object;

	@Override
	public void run() {
		
		while(count <= 10) {
			
			if(count %2 == 0 && Thread.currentThread().getName().equals("even")) {
				synchronized (object) {
					System.out.println(Thread.currentThread().getName() + count);
					count++;
					try {
						object.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
			if(count %2 != 0 && Thread.currentThread().getName().equals("odd")) {
				synchronized (object) {
					System.out.println(Thread.currentThread().getName() + count);
					count++;
					object.notify(); 
				}
				
			}
		}
	}
	
        public static void main(String[] args) {
        Object lock1 = new Object();	
        Runnable r1 = new MultiThreadEx(lock1);
        Runnable r2 =  new MultiThreadEx(lock1);
        new Thread(r1,"even").start();
        new Thread(r2,"odd").start();
		}

}
