package com.java.threadPractice;


class Add implements Runnable {
	
	int total;
	

	@Override
	public synchronized void run() {
			for(int i=0;i<100;i++) {
				
				this.total += i;
			}
			this.notify();
	}
	
}

public class MainThread {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		Add add = new Add();
		Thread t = new Thread(add);
		t.start();
		t.join();
		t.setDaemon(true);
		synchronized (add) {
			add.wait();
			System.out.println(add.total);
		}

	}
	
	class SharedResource {
	    private  boolean running = true;

	    public void start() {
	        new Thread(() -> {
	            while (running) {
	                // Simulating some work
	                System.out.println("Thread is running...");
	                try {
	                    Thread.sleep(500);
	                } catch (InterruptedException e) {
	                    Thread.currentThread().interrupt(); // Restore interrupt status
	                }
	            }
	            System.out.println("Thread has stopped.");
	        }).start();
	    }

	    public void stop() {
	        running = false; // This change will be visible to the running thread
	    }
	}

}
