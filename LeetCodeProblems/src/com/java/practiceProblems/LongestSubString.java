package com.java.practiceProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LongestSubString {
	
	 public static String findLongestUniqueSubstring(String s) {
	        int left = 0, right = 0, maxLength = 0, start = 0;
	        Set<Character> seen = new HashSet<>();

	        while (right < s.length()) {
	            char ch = s.charAt(right);

	            // If the character is already in the set, move the left pointer to the right of the duplicate
	            while (seen.contains(ch)) {
	                seen.remove(s.charAt(left));
	                left++;
	            }

	            seen.add(ch);
	            
	            // Update max length and start index if a new longest unique substring is found
	            if (right - left + 1 > maxLength) {
	                maxLength = right - left + 1;
	                start = left;
	            }
	            right++;
	        }
	        
	        return s.substring(start, start + maxLength);
	    }

	public static void main(String[] args) {
		/*
		 * String s1 = "abcabcbbz"; System.out.println("Longest Unique Substring: " +
		 * findLongestUniqueSubstring(s1));
		 */
		//countSubstring();
		printOccurence(streamsOccurence());
	}
	
	public static void countSubstring() {
		String input = "abcdsdgfabcijhjncabc";
		String find = "abc";
		int index = 0,occurence = 0;
		while((index = input.indexOf(find,index))!=-1) {
			occurence++;
			index +=find.length();
		}
		System.out.println("occurence "+occurence);
	}

    public static void countSubstringusingStreams() {
        String input = "abcdsdgfabcijhjncabc";
        String find = "abc";

        // Using Pattern.matcher to find all occurrences of the substring "find"
        long occurrence = Pattern.compile(Pattern.quote(find)) // Safely compile the substring
                .matcher(input)                          // Create a matcher for the input string
                .results()                                // Get a stream of MatchResult objects
                .count();                                 // Count the number of matches

        System.out.println("Occurrence: " + occurrence);
    }
    
    public static List<Map<Integer,Long>> streamsOccurence() {
    	List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,3,6,1,8,6,0,3,4,8,8));
    	
    	List<Map<Integer,Long>> sorted =  nums.stream()
    	    .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
    	    .entrySet()
    	    .stream()
    	    .sorted(Comparator.comparing(Map.Entry<Integer,Long>::getValue,Comparator.reverseOrder())
    	    		          .thenComparing(Map.Entry::getKey,Comparator.reverseOrder()))
    	    .map(entry ->{
    	    	Map<Integer,Long> map = new HashMap<>();
    	    	map.put(entry.getKey(), entry.getValue());
    	    	return map;
    	    })
    	    .collect(Collectors.toList());
    	return sorted;
    }
    
    public static void printOccurence(List<Map<Integer,Long>> sorted) {
    	  sorted.forEach(map -> map.forEach((key, value) -> {
              for (long i = 0; i < value; i++) {
                  System.out.print(key + " ");
              }
          }));
    }
}
