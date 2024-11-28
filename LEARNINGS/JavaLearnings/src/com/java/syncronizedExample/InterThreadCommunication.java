package com.java.syncronizedExample;

class Q{
	int num;
	boolean valueSet = false;
	
	public synchronized void put(int num) {
		
		while(valueSet) {
			try {wait();} catch (InterruptedException e) {e.printStackTrace();};
		}
		System.out.println("put : "+num);
		this.num = num;
		valueSet = true;
		notify();
	}
	
	public synchronized void get() {
		while(!valueSet) {
			try {wait();} catch (InterruptedException e) {e.printStackTrace();};
		}
		System.out.println("get : "+num);
		valueSet = false;
		notify();
	}
}

class Producer implements Runnable{
	
	Q q;
	
	public Producer(Q q){
		this.q = q;
		Thread t = new Thread(this,"Producer-Thread");
		t.start();
	}

	@Override
	public void run() {
	  int i=0;
	  while(true) {
		  q.put(i++);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	  }
		
	}
	
}

class Consumer implements Runnable{
    Q q;
	
	public Consumer(Q q){
		this.q = q;
		Thread t1 = new Thread(this,"Consumer-Thread");
		t1.start();
	}
	@Override
	public void run() {
		while(true) {
			q.get();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class InterThreadCommunication {
	
	public static void main(String[] args) {
		Q q  =new Q();
		Producer producer = new Producer(q);
		Consumer consumer = new Consumer(q);
		System.out.println("hi");

	}
	
}
