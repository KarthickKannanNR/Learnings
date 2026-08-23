package org.example;

public class InitializingTest {

    public static void main(String[] args) {

    }

    static int x = print();

    static{
        System.out.println("Static block");
    }

    static int print(){
        System.out.println("Initializing x");
        return 10;
    }

}
