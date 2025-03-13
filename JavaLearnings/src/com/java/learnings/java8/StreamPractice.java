package com.java.learnings.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamPractice {
	
	public static void streamMapProblems() {
		 List<Integer> nums  =  Arrays.asList(9,3,5,1,9,2,3,64,18,3,20,5,1,1);
		 Map<Integer,Long> grouped  =  nums.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				                                    .entrySet()
		                                            .stream()
		                                            .sorted( Comparator.comparing(Map.Entry<Integer, Long>::getValue, Comparator.reverseOrder()) // Sort by value (desc)
		                                                    .thenComparing(Map.Entry.comparingByKey(Comparator.reverseOrder()))	  
		                                              )
		                                            .collect(Collectors.toMap(
		                                    		   Map.Entry::getKey, 
		                                    		   Map.Entry::getValue,
				                                       (oldValue, newValue) -> newValue,
		                                    		   LinkedHashMap::new
		                                    		 ));
		 System.out.println(grouped);
		 
		 
			List<Integer> sortedOccurence = nums.stream()
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
					.entrySet()
					.stream()
					.sorted(Comparator.comparing(Map.Entry<Integer, Long>::getValue, Comparator.reverseOrder())																				
							.thenComparing(Map.Entry::getKey,Comparator.reverseOrder()))
					.flatMap(entry -> IntStream.range(0, entry.getValue().intValue()).mapToObj(i -> entry.getKey()))
					.collect(Collectors.toList());
			System.out.println(sortedOccurence);
	}
	
	
	public static void thenComparingEx() {
		int []arr= new int[]{9,3,5,1,9,2,3,64,18,3,20,5,1,1};
	    

		List<Integer> list =  Arrays.stream(arr)
		                .boxed()
		                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		                .entrySet()
		                .stream()
		                .sorted((a,b) -> a.getValue().equals(b.getValue()) ? b.getValue().compareTo(a.getValue())
		                		                                           : b.getValue().compareTo(a.getValue()))
		                .flatMap(e -> IntStream.range(0, e.getValue().intValue()).mapToObj(i -> e.getKey()))
		                .collect(Collectors.toList());
	    System.out.println(list);	          
	}
	
	public static void withoutGrpBy() {
		 List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

		 Map<String, Integer> wordCount = words.stream()
		     .collect(Collectors.toMap(
		         word -> word, // Key: The word
		         word -> 1,    // Value: Initialize count as 1
		         Integer::sum  // Merge function: Sum occurrences
		     ));

		 System.out.println(wordCount);
	}

	public static void main(String[] args) {
		thenComparingEx();
	}

}
