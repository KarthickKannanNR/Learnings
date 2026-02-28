package org.example;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int []arr = {92,45,1,2,3,4};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /**
    selection sort - O(n2)
     **/
    public static void selectionSort(int []arr){
        if(arr.length > 1){
            for(int i =0 ;i < arr.length;i++){
                int min_index = i;
                int min = arr[i];
                for(int j = i+1;j<arr.length; j++){
                    if(arr[j] < min){
                        min = arr[j];
                        min_index = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[min_index];
                arr[min_index] = temp;
            }
        }
    }
}
