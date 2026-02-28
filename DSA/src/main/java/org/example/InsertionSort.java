package org.example;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int []arr = {92,45,1,2,3,4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * selection sort - O(n2)
     **/
    public static void sort(int [] arr){
        for(int i = 1; i < arr.length;i++){
            int temp = arr[i];
            int j = i-1;

            while(j >= 0 && arr[j]>temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }

    }
}
