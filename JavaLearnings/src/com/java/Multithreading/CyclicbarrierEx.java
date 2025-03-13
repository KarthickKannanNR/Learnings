package com.java.Multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import com.java.Multithreading.*;

public class CyclicbarrierEx {

	public static void main(String[] args) {
			
		CyclicBarrier barrier = new CyclicBarrier(3,()->{
			System.out.println("All the thread reached barrier, So this coded is executed");
		    try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		for(int i=0;i<3;i++) {
			new Thread(new WorkerThread(barrier)).start();
		}

	}

}

class WorkerThread implements Runnable{
    private CyclicBarrier barrier;
	
	public WorkerThread(CyclicBarrier barrier) {
		this.barrier =  barrier;
	}
	
	@Override
	public void run() {
		System.out.println("Thread started");
		try {
			Thread.sleep(1000);
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println("Thread Ended");
	}
	
}
