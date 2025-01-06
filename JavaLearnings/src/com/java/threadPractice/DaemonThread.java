package com.java.threadPractice;

public class DaemonThread {
	
	public static void print() throws InterruptedException {
		Thread.sleep(3000);
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		DaemonChildThread obj = new DaemonChildThread();
		Thread thread = new Thread(obj);
		thread.setDaemon(true);
		thread.start();
		Thread.sleep(5000);
		System.out.println("main thread sleep ended");
	}

}

class DaemonChildThread implements Runnable{
	
	public void run() {
		try {
			Thread.currentThread().sleep(2000);
			System.out.println("run() called");
			run();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
