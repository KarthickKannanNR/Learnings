package org.example;

import java.util.Stack;

class Node{
    int data;
    Node next;

    Node(int data){
       this.data = data;
    }
}
public class StackLinkedList {

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.print();
    }

    void print(){
        if(top != null){
            Node temp = top;
            while(temp != null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
        }
    }

    void push(int data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    int pop(){
        if(top == null){
            System.out.println("😂 Stack is empty");
            return Integer.MIN_VALUE;
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    int peek(){
        return top != null ? top.data: Integer.MIN_VALUE;
    }

    boolean isEmpty(){
        return top == null;
    }

    Node top = null;

}
