package com.java.threadPractice;

import java.util.ArrayList;

class ThreadClass implements Runnable{
	int value;
	
	ThreadClass(int value){
		this.value = value;
	}
	public void run() {
//		for(int i=0;i<100;i++) {
//			System.out.println(i);
//		}
	}
}

public class DaemonThreadEx {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ThreadClass tc = new ThreadClass(1);
		Thread t = new Thread(tc);
		//t.setDaemon(true);
		t.start();
		System.out.println("main thread");
		tc.value = 5;
		System.out.println(tc.value);
		ArrayList<ThreadClass> tcList = new ArrayList<>();
		tcList.add(new ThreadClass(50));
		System.out.println(tcList.get(0).value);
		System.gc();
		System.out.println(tc.value);
		System.out.println(tcList.get(0).value);

		
	}

}
