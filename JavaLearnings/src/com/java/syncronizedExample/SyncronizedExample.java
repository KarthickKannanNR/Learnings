package com.java.syncronizedExample;

class SyncronizedClass{
	 int count;
	
		public synchronized void increment() {
			count++;
		}
	
}

public class SyncronizedExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SyncronizedClass obj = new SyncronizedClass();
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=1;i<=4000;i++) {
					obj.increment();
				}
			}
		});
		t.start();
		
       Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=1;i<=6000;i++) {
					obj.increment();
				}
			}
		});
       t2.start();
       
       System.out.println(obj.count);

	}

}
