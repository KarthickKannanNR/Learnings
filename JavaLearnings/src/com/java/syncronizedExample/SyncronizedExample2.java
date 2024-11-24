package com.java.syncronizedExample;

class counter {
	int count ;

	public synchronized void increment() {
		count++;
	}
	

	public synchronized void increment2() {
		count++;
	}
}

public class SyncronizedExample2 {

	public static void main(String[] args) throws InterruptedException {
		counter c = new counter(); 
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
                 for(int i=0;i<500;i++) {
                	 c.increment();
                 }				
			}
		});
		
      Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
                 for(int i=0;i<500;i++) {
                	 c.increment2();
                 }				
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(c.count);
	}

}
