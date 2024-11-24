package com.java.Multithreading;

import java.util.concurrent.CompletableFuture;

public class CompletableFuture3 {
	public static void main(String[] args) {
        // Start an asynchronous task to calculate a value
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            // Simulate a long-running task
            try {
                Thread.sleep(5000); // Simulate delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return 42; // Return a result
        });

        // Continue doing other work while the task runs in the background
        System.out.println("Doing other work...");

        // Get the result of the asynchronous task (blocks if not completed yet)
        future.thenAccept(result -> {
            System.out.println("Result of the computation: " + result);
        });

        // Keep the main thread alive for a while to see the result
        try {
        	System.out.println("main thread sleeping");
            Thread.sleep(30000); // Wait long enough for the async task to complete

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
