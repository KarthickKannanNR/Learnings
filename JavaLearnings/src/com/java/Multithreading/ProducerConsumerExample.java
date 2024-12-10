package com.java.Multithreading;

import static  com.java8.innerClasses.NonStaticInnerClass.staticOuterfield;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class SharedResource  {

	private int count = 0;
    private final int LIMIT = 5;

    public synchronized void produce() throws InterruptedException {
        while (count >= LIMIT) {
            wait(); // Wait until notified
        }
        count++;
        System.out.println("Produced: " + count);
        System.out.println("static variable import :"+staticOuterfield);
        //Thread.currentThread().interrupt();; 
        // Notify waiting consumers
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (count <= 0) {
            wait(); // Wait until notified
        }
        count--;
        System.out.println("Consumed: " + count);
        notify(); // Notify waiting producers
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        List<Integer> num = new ArrayList<>();
        num.add(0);
        
       Future<Integer> s = Executors.newSingleThreadExecutor().submit(() ->6);

        // Producer thread
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    resource.produce();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        // Consumer thread
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    resource.consume();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

    }
}
