package com.java.comparableAndComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class StreamsPracticePrograms extends ComparableAndComparatorRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> numList = new ArrayList<>(Arrays.asList(1,2,3,4,5,56,7,5,8,10,56,53));
		
		System.out.println("partitioningBy even and odd");
		Map<Boolean, List<Integer>> evenOddList =  numList.stream().collect(Collectors.partitioningBy(n -> n%2==0));
		System.out.println(evenOddList+"\n");	
		
		System.out.println("distict list by convertig set");
	    Set<Integer> numSet =	 numList.stream().collect(Collectors.toSet());
		System.out.println(numSet);
		
		System.out.println("distict list by distinct");
		List<Integer> distinctList = numList.stream().distinct().collect(Collectors.toList());
		System.out.println(distinctList);
		
		
		System.out.println("frequency of chars");
		String freq = "jhbkjygkjhhb";
		
		Map<Character, Long> charFrequency =  freq.chars().mapToObj(c -> (char) c)
		            .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		Arrays.asList(freq.split("")).stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		System.out.println(charFrequency);
		
		System.out.println("frequency of element in an array");
		Map<Integer,Long> frequencyInList = numList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(frequencyInList);
		
		List<String> nameList = new ArrayList<>(Arrays.asList("jhtft"));
		nameList.add("jhtft");
		nameList.add("tresuy");
		Map<String,Long> stringListFreq = nameList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(stringListFreq);
		
		System.out.println("Joining Func");
		String joinFunc = nameList.stream().collect(Collectors.joining(",","[","]"));
		System.out.println(joinFunc);
		
	}

}
