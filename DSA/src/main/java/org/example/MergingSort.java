package org.example;

import java.util.Arrays;

public class MergingSort {

    public static void main(String[] args) {
        int []arr1 = {1,3,7,9};
        int []arr2 = {1,2,5,6};
        int []arr3 = {1,5,3,0,9,6};
        recursiveMergeSort(arr3, 0, arr3.length);
        System.out.println(Arrays.toString(arr3));
    }

    /**
     *
     * @param arr
     * @param start
     * @param end
     * @param mid
     * N(log N)
     **/
    public static void mergeSort2(int []arr, int start, int end, int mid){
        int []cArr = new int[arr.length];
        int i = start, j = mid, k = start;

        while(i<mid && j<end){
            if(arr[i] < arr[j]){
                cArr[k++] = arr[i++];
            }else{
                cArr[k++] = arr[j++];
            }
        }

        while(i < mid){
            cArr[k++] = arr[i++];
        }
        while(j < end){
            cArr[k++] = arr[j++];
        }
        for(int itr =start; itr < end; itr++){
            arr[itr] = cArr[itr];
        }

    }

    public static void recursiveMergeSort(int arr[], int start, int end){
        if(end - start == 1){
            return;
        }

        int mid = (start+end)/2;
        recursiveMergeSort(arr, start, mid);
        recursiveMergeSort(arr, mid, end);
        mergeSort2(arr, start, end, mid);
    }


    /**
      mergeSort O(n)
     **/
    public static int[] mergeSort(int []arr1, int []arr2){
        int []arr3 = new int[arr1.length+arr2.length];
        int i = 0, j = 0, k = 0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i] < arr2[j]){
                arr3[k++] = arr1[i++];
            }else{
                arr3[k++] = arr2[j++];
            }
        }

        while(i<arr1.length){
            arr3[k++] = arr1[i++];
        }
        while(j<arr2.length){
            arr3[k++] = arr2[j++];
        }

        return arr3;
    }
}
