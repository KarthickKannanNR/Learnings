package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseArrayTwoPointer {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(2,5,7,190,24,67,13,16,31));
        System.out.println(nums);
        int i=0,j=nums.size()-1;

        while(i < j){
            int temp = nums.get(i);
            nums.set(i,nums.get(j));
            nums.set(j,temp);
            i++;
            j--;
        }
        System.out.println(nums);
    }
}
