package com.java.Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class RunnableClass implements Callable<Integer>{
	 int i =0;
	
	@Override
	public Integer call() {
		// TODO Auto-generated method stub
		System.out.println("Running ");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i++;
	}
	
}

public class ExecutorServiceWithRunnable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		ExecutorService service = Executors.newFixedThreadPool(20);
		List<Future<?>> futureList = new ArrayList<>();
		for(int i=0;i<100;i++) {
			futureList.add(service.submit(new RunnableClass()));  
			futureList.add(service.submit(new RunnableClass()));  

		}
		System.out.println("after loop");
		service.shutdown();
		System.out.println(service.isTerminated());
		for(Future<?> i:futureList) {
			i.get();
		}
		System.out.println("after all task completed");
		System.out.println(service.isTerminated());

	}

}
