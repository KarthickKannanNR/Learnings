package com.java.Multithreading;

import java.util.concurrent.RecursiveTask;

public class FibonacciWithForkJoinPool extends RecursiveTask<Integer>{

	final int i;
	FibonacciWithForkJoinPool(int i){
		this.i= i;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer compute() {
		// TODO Auto-generated method stub
		
		if(i<=1)
			return i;
		FibonacciWithForkJoinPool f1 = new FibonacciWithForkJoinPool(i-1);
		f1.fork();
		FibonacciWithForkJoinPool f2 = new FibonacciWithForkJoinPool(i-2);
		f2.fork();
		
		return f2.join() + f1.join();
	}

}
