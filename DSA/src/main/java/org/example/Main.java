package org.example;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        searchMaxIn2DArray();
    }

    public static void searchMaxIn2DArray(){
        int[][] arr = {{2,67,15,3},{78,25,61,37},{16,18},{56,81,25,67,17}};
        System.out.println(searchMaxIn2DArray(arr));
    }


    public static void searchIn2DArrayCaller(){
        int[][] arr = {{2,67,15,3},{78,25,61,37},{16,18},{56,81,25,67,17}};
        int target = 17;
        System.out.println(Arrays.toString(searchIn2DArray(arr, target)));
    }

    public static int[] searchIn2DArray(int[][] arr, int target){

        for(int row = 0; row< arr.length; row++){
            for(int column = 0; column< arr[row].length; column++){
                if(arr[row][column] == target){
                    return new int[]{row, column};
                }
            }
        }

        return new int[]{-1,-1};
    }

    public static int searchMaxIn2DArray(int[][] arr){
        int max = arr[0][0];
        for(int row = 0; row< arr.length; row++){
            for(int column = 0; column < arr[row].length; column++){
                if(arr[row][column] > max){
                    max = arr[row][column];
                }
            }
        }
        return max;
    }

}