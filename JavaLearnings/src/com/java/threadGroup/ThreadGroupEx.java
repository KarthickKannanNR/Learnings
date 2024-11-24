package com.java.threadGroup;


class Mythread extends Thread{
	 public Mythread(ThreadGroup cg, String name) {
		super(cg,name);
	}

	public void run() {
		 System.out.println(Thread.currentThread().getName()+" Starts");
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
}
public class ThreadGroupEx {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ThreadGroup pg = new ThreadGroup("ParentGroup");
		ThreadGroup cg = new ThreadGroup(pg,"ChildGroup");
		Mythread t1 = new Mythread(cg,"thread1");
		Mythread t2 = new Mythread(cg,"thread2");
		t1.start();
		t2.start();
		pg.list();
		System.out.println(pg.activeCount());
		System.out.println(pg.activeGroupCount());
		Thread.sleep(10000);
		System.out.println(pg.activeCount());
		System.out.println(pg.activeGroupCount());
        Thread.currentThread().getThreadGroup().getParent().list(); 

	}

}
