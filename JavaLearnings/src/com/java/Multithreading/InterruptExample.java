package com.java.Multithreading;

import java.util.Random;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            //while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Thread is running...");
                Thread.currentThread().wait(); // Simulating work
            //}
            
        } catch (Exception e) {
            System.out.println("Thread was interrupted during sleep.");
            // Handle cleanup or resource release if necessary
        }
        System.out.println("Thread is exiting.");
    }
}

public class InterruptExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        
        // Let the thread run for a few seconds
        Thread.sleep(3000);

        // Interrupt the thread
        System.out.println("Interrupting the thread...");
        //thread.notify();
        thread.interrupt();
        
        // Wait for the thread to finish
        thread.join();
        System.out.println("Main thread has finished.");
    }
}
