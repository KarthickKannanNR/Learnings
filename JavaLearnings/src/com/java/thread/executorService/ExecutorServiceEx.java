package com.java.thread.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class PrintJob implements Runnable{
	String name;
	public PrintJob(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		System.out.println(name+" job started by "+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+" job Ends by "+Thread.currentThread().getName());
	}
	
	
}
public class ExecutorServiceEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		PrintJob[] jobs = {new PrintJob("karthick"),
		                   new PrintJob("akash"),
		                   new PrintJob("alamelu"),
		                   new PrintJob("rajan"),
		                   new PrintJob("kk"),
		                   new PrintJob("ak")};
		
		for(PrintJob job : jobs) {
			service.submit(job);
		}
		service.shutdown();
		
	}

}
