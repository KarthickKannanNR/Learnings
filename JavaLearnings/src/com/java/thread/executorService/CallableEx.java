package com.java.thread.executorService;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class SumNumbers implements Callable<Object>{
	int num;
	public SumNumbers(int num) {
		this.num = num;
	}
	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		int sum =0;
		for(int i=1;i<=999999999;i++) {
			sum+= i;
		}
		System.out.print(Thread.currentThread().getName()+" :");
		return sum;
		
	}
	
	
}

public class CallableEx {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		SumNumbers[] sums = {
				new SumNumbers(10),
				new SumNumbers(20),
				new SumNumbers(30),
				new SumNumbers(40),
				new SumNumbers(50),
		};
		ExecutorService service = Executors.newFixedThreadPool(3);
		for(SumNumbers job:sums) {
			Future<Object> total = service.submit(job);
			System.out.println("calculated by "+total.get());
		}
		service.shutdown();

	}

}
