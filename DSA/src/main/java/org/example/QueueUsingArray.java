package org.example;

public class QueueUsingArray {
    int front = -1;
    int rear = -1;
    int arr[];
    int size = 10;

    QueueUsingArray(){
        arr = new int[size];
    }

    void enqueue(int data){
        if(rear == size-1){
            throw new IndexOutOfBoundsException("Queue is full");
        }
        if(front == -1 && rear == -1){
            front++;
            arr[++rear] = data;
            return;
        }
        arr[++rear] = data;
    }

    int dequeue(){
        if(front == -1 && rear == -1 || front > rear){
            throw  new UnsupportedOperationException("Queue is empty");
        }
        return arr[front++];
    }
}
