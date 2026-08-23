package org.example;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {



    public static void main(String[] args) {
        int []arr = {2,7,11,15};
        int target = 9;
        int []result = returnIndex(arr,target);
        System.out.println(result != null ? result.toString():"");
    }

    public static int[] returnIndex(int [] arr, int target){
        Map<Integer,Integer> numIndex = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int diff = target - arr[i];
            if(numIndex.containsKey(diff)){
                System.out.println(numIndex.get(diff)+" "+i);
                return new int[]{numIndex.get(diff),i};
            }
            numIndex.put(arr[i],i);
        }
        return null;
    }
}
