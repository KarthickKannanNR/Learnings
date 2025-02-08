package com.java.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterviewCodingQuestoin {

	public static void main(String[] args) {
		findAnagram();
	}
	
	public static void mergeSortedArr() {
		List<Integer> nums1 = new ArrayList<>(Arrays.asList(6,9,9));
		List<Integer> nums2 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,10,11,12,13,14,15));
		List<Integer> merged = new ArrayList<>();
		int i =0,j=0;
		
		while(true) {
			if(nums1.get(i)<nums2.get(j)) {
				merged.add(nums1.get(i));
				i++;
			}else if(nums1.get(i)>nums2.get(j)){
				merged.add(nums2.get(j));
				j++;
			}else {
				merged.add(nums1.get(i));
				merged.add(nums2.get(j));
				i++;
				j++;
			}
			if(i>=nums1.size()) {
				merged.addAll(merged.size(),nums2.subList(j, nums2.size()));
				break;
			}else if(j>=nums2.size()){
				merged.addAll(merged.size(),nums2.subList(i, nums2.size()));
				break;
			}
		}
		System.out.println(merged);
		String[] arr = new String[4];
	}
	
	public static void mergeSortedArr2() {
		List<Integer> nums1 = new ArrayList<>(Arrays.asList(6,9,9));
		List<Integer> nums2 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,10,11,12,13,14,15));
		List<Integer> merged = new ArrayList<>();
		int i =0,j=0;
		
        while (i < nums1.size() && j < nums2.size()) {
            if (nums1.get(i) <= nums2.get(j)) {
                merged.add(nums1.get(i));
                i++;  
            } else {
                merged.add(nums2.get(j));
                j++;  
            }
        }

        while (i < nums1.size()) {
            merged.add(nums1.get(i));
            i++;
        }

        while (j < nums2.size()) {
            merged.add(nums2.get(j));
            j++;
        }

        System.out.println(merged);
	}
	
	public static void reverseWord() {
		String input = "karThICk";
		String output = "";
		for(int i=input.length()-1;i>=0;i--) {
			if(i==0) {
				String temp = "";
				temp += input.charAt(i);
				output+=temp.toUpperCase();
			}else {
				output+=input.charAt(i);
			}
		}
		System.out.println(output);
	}
	
	public static void convertChar() {
		String input = "GuNa";
		String output = "";
		
		for(int i=0;i<=input.length()-1;i++) {
			char c = input.charAt(i);			
			if(c>=65 && c<=90) {
				output+= Character.toString(c).toLowerCase();
			}else {
				output+= Character.toString(c).toUpperCase();
			}
		}
		System.out.println(output);
	}
	
	public static void findAnagram() {
		String str1 = "nana       ";
		String str2 = "nana";
		
		str1 = Stream.of(str1.replaceAll("\\s", "")).map(String::toUpperCase)
				                        .collect(Collectors.joining());
		
		str2 = Stream.of(str2.replaceAll("\\s", "")).map(String::toUpperCase)
				                        .collect(Collectors.joining());
		
		System.out.println("Anagram "+str1.equals(str2));
	}

}
