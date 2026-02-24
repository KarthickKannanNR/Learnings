package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array {
    @Override
    public String toString() {
        return "Array{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    private int [] arr;
    int size;
    private int capacity;

    public Array(int capacity){
        arr = new int[capacity];
        size = 0;
        this.capacity = capacity;
    }

    public boolean add(int index, int element){
        if(index < 0 || index >= capacity || index > size){
            System.out.println("Invalid Index : "+ index);
            return false;
        }else if(size == capacity){
            System.out.println("Arays is already full");
            return false;
        }

        for(int i = size; i > index ; i--){
            arr[i] = arr[i-1];
        }
        arr[index] = element;
        size++;

        return true;
    }

    public boolean add(int element){
        if(size >= capacity){
            System.out.println("Array is already full, Can't insert element : "+ element);
            return false;
        }
        arr[size] = element;
        size++;
        return true;
    }

    public int get(int index){
        return arr[index];
    }

    public void set(int index, int element){
        if(index > capacity || index < 0){
            System.out.println("Invalid index");
        }else {
            arr[index] = element;
        }
    }

    public static void main(String[] args) {
        Array arr = new Array(5);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(2,9);
        arr.add(3,10);
        System.out.println(arr);
    }
}
