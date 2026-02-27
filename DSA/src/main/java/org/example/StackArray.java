package org.example;

public class StackArray {
    private int size;
    private int []stack;
    private int top = -1;
    public StackArray(){
        size = 100;
        stack = new int[size];
    }

    void push(int value){
        if(top == size-1){
            System.out.println("Stack overflow");
            return;
        }
        stack[++top] = value;
    }

    int pop(){
        if(top < 0){
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }

    int peek(){
        return stack[top];
    }

    boolean isEmpty(){
        if(top == -1){
            return true;
        }
        return false;
    }

    void print(){
        for(int i = top; i >=0; i--){
            System.out.print(stack[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray();
        stack.push(5);
        stack.push(10);
        stack.push(2);
        System.out.println(stack.isEmpty());
        stack.print();
        System.out.println(stack.peek());
        stack.pop();
        stack.print();
        stack.pop();
        stack.pop();
        stack.print();

        for (int i = 0; i <= 100; i++)
            stack.push(i);

    }
}
