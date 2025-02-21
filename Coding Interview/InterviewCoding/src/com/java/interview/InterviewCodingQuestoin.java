package com.java.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterviewCodingQuestoin {

	public static void main(String[] args) {
		reverseChar();
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
		String str1 = "astronomers       ";
		String str2 = "moon starers";
		
		char[] arr1 = str1.toLowerCase().replaceAll("\\s", "").toCharArray(); 
		char[] arr2 = str2.toLowerCase().replaceAll("\\s", "").toCharArray(); 

		Arrays.sort(arr1);
		Arrays.sort(arr2);
		System.out.println(Arrays.equals(arr1, arr2));
	}
	
	public static void twoDimArrPrblm1() {
		int [][]arr = new int[3][3];
		arr[0][0] =1;arr[0][1] =0;arr[0][2] =1;
		arr[1][0] =1;arr[1][1] =1;arr[1][2] =1;
		arr[2][0] =1;arr[2][1] =1;arr[2][2] =0;
		boolean found = false;
		
		for(int i=0;i<arr.length;i++) {
			found =false;
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j]==0) {
					found = true;
					for(int k=0;k<arr[i].length;k++) {
						arr[i][k]=0;
					}
				}
				if(found) break;
			}
			System.out.println();
		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	
	public static void findOccurenceAndSort() {
		List<Integer> nums = Arrays.asList(8,7,2,5,1,7,9,2,5,1,5,2,2,8,8);
		Map<Integer,Long> occurence = nums.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		Map<Integer,List<Integer>> groupedByOccur = occurence.entrySet()
				                                    .stream().collect(Collectors.groupingBy(
				                                    		  entry -> entry.getValue().intValue(),
				                                    		   Collectors.mapping(Map.Entry::getKey, 
				                                    			Collectors.collectingAndThen(Collectors.toList(), list ->{
							                                    Collections.sort(list.reversed());
							                                    return list;
							                                   }))
				                                    		));
		
		System.out.println(occurence);
		System.out.println(groupedByOccur);
		
		  for(Map.Entry<Integer, List<Integer>> entry:groupedByOccur.entrySet()) {
			  System.out.print(entry.getKey()+" ");
			  for(int i:entry.getValue()) {
				  for(int j=0;j<entry.getKey();j++) {
					  System.out.print(i);
				  }
				  System.out.print(" ");
			  }
			  System.out.println();
		  }
		 
	}
	
	public static void sortMap() {
		Map<Integer,Integer> map = new HashMap<>();
		map.put(1, 200);
		map.put(4, 100);
		map.put(2, 300);
		map.put(2, 50);
		
		Map<Integer,Integer> sortedMap = map.entrySet()
		   .stream()
		   .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(val1,val2)->val1,TreeMap::new));
		System.out.println(sortedMap);

	}
	
	//find longest non repeating substr
	public static String findLongedtSubStr() {
		String input = "Aabbdienbddhjabyekjsabd";
		List<String> subStrs = new ArrayList<>();
		int p = 0;
		String s = "";
		for(int i=0;i<input.length();i++) {
			while(i<input.length() && !s.contains(Character.toString(input.charAt(i)))) {
				s = s.concat(Character.toString(input.charAt(i)));
				i++;
				p++;
			}
			subStrs.add(s);
			if(p+1 >=input.length()) break;
			p--;
			s= "";
		}
		System.out.println(subStrs);
		return subStrs.stream().max((val1,val2) -> val1.length() - val2.length()).get();
	}
	
	public static void reverseChar() {
		String input = "123456789";
		String output = "";
		int n =1;
		
		for(int i=0;i<input.length();i++) {
			while(n==3) {
				output += input.charAt(i);
				n++;
			}
			n=1;
		}
		System.out.println(output);
	}
	

}
