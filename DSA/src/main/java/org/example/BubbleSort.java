package org.example;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int []arr = {92,45,1,2,3,4};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int []arr){
        if(arr.length > 1){
            for(int i =0 ; i < arr.length-1; i++){
                System.out.println(i);
                boolean swapped = false;
                for(int j = 0; j < arr.length-i-1; j++){
                    if(arr[j] > arr[j+1]){
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        swapped = true;
                    }
                }
                if(!swapped) return;
            }
        }
    }

}
