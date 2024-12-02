package com.java.threadPractice;

public class FindandPrintEvenOddNumberswithThreads {

	 static int maxCount = 20;
	 static boolean isEvenTurn =false;
	 static Object lock = new Object();

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Thread evenThread  = new Thread(()->{
			
			for(int i=2;i<maxCount;i+=2) {
				
				synchronized (lock) {
					while(!isEvenTurn) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("even number "+i);
					isEvenTurn = false;
					lock.notify();
				}
				
			}
		});
		
		
        Thread oddThread  = new Thread(()->{
			
        	
			for(int i=1;i<maxCount;i+=2) {
				synchronized (lock) {
					while(isEvenTurn) {
		        		try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("odd number "+i);
					isEvenTurn =true;
					lock.notify();
				}
			}
		});

        evenThread.start();
        oddThread.start(); 
        System.out.println("ends");
	}

}
