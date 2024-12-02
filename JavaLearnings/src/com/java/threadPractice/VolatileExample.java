package com.java.threadPractice;

class ThreadImpl implements Runnable{

	 boolean flag;
	@Override
	public void run() {
		
		while(!flag) {
			System.out.println("While loop");
			Thread.yield();
		}
		System.out.println("flag status change progam ends");
		
	}
	
}

class ThreadImp2 implements Runnable{

	 boolean flag;
	@Override
	public void run() {
		
		while(!flag) {
			System.out.println("While loop 2");
		}
		System.out.println("flag status change progam ends");
		
	}
	
}

public class VolatileExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ThreadImpl t1 = new ThreadImpl();
		ThreadImp2 t2 = new ThreadImp2();
		Thread thread = new Thread(t1);
		Thread thread2 = new Thread(t2);

		thread.start();
		thread2.start();

		
		
		
	}

}
