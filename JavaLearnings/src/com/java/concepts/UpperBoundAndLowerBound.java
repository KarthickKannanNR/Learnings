package com.java.concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UpperBoundAndLowerBound {

	public static void main(String[] args) throws InterruptedException {
		List<Object> numList =  new ArrayList<>(Arrays.asList(1.1,2.2,3.3,4.4,5.5));
		iterateList(numList);
	}

	
	public static void iterateList(List<? super String> list) throws InterruptedException {
		list.add("kjtf");
		System.out.println(list);
		
		
		  ExecutorService executor = new ThreadPoolExecutor(
	                0, Integer.MAX_VALUE, // Min 0, Max unlimited threads
	                60L, TimeUnit.SECONDS,
	                new SynchronousQueue<>()
	        );

	        for (int i = 1; i <= 10; i++) {
	            final int taskNumber = i;
				Thread.sleep(1000);

	            executor.execute(() -> {
	                System.out.println(Thread.currentThread().getName() + " executing task " + taskNumber);
	            });
	        }

	        executor.shutdown();
	}
}
