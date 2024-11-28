package com.java.threadPractice;

public class ThreadPriority {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread(()->{
			for(int i=0;i<10;i++) {
				System.out.println("Child Thread "+i);
			}
		});
		t.setPriority(9);
		t.start();
		for(int i=0;i<10;i++) {
			System.out.println("Main Thread "+i);
		}
	}

}
