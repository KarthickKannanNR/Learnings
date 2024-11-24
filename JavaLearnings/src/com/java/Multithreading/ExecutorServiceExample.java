package com.java.Multithreading;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class ThreadClass implements Callable<Integer>{

	@Override
	public Integer call() {
		try {
			Thread.sleep(3000);
			System.out.println("called");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
	
}
public class ExecutorServiceExample {

	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		List<Callable<Integer>> callableList = new ArrayList<>();
		List<Future<Integer>> futureList = new ArrayList<>();

		ExecutorService ex = Executors.newFixedThreadPool(20);
		
		for(int i=0;i<100;i++) {
			callableList.add(new ThreadClass());
			//futureList.add(ex.ubmit(new ThreadClass()));
		}
		futureList = ex.invokeAll(callableList);
		//ex.shutdown();
		if(ex.awaitTermination(2,TimeUnit.SECONDS)){
			System.out.println("all task is completed");
		}else {
			System.out.println("Task is still not completed");
			System.out.println(ex.isShutdown());
		}
		System.out.println("ended");
		futureList.get(4).cancel(true);
		try {
			for(Future<?> f:futureList) {
				//Integer i = (Integer) f.get();
				System.out.println((Integer) f.get());
			}
		}catch(Exception w) {
			
		}
		
		System.out.println("Before shutdown");
		ex.shutdownNow();
		System.out.println("After shutdown");

	}

}
