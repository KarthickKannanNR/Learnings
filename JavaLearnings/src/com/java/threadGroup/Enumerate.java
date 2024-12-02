package com.java.threadGroup;

public class Enumerate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
		Thread[] t = new Thread[system.activeCount()];
		System.out.println(system.activeCount());
		system.enumerate(t);
		System.out.println(t); 
		for(Thread threads:t) {
			System.out.println(threads.getName());
		}

	}

}
