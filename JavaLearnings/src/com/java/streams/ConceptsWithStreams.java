package com.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class ConceptsWithStreams{

	public static void flatMapEx() {
		List<List<String>> name = Arrays.asList( Arrays.asList("karthick","akash"), Arrays.asList("rajan","alamelu"));
		List<String> flatMapList = name.stream().flatMap(list->list.stream()).collect(Collectors.toList());
		flatMapList.forEach(System.out::println);
	}
	
	public static void anyMatch() {
		List<String> status = Arrays.asList("online","online","offline");
		Predicate<String> offileStatusPredicate = statusList -> statusList.equalsIgnoreCase("offline");
		System.out.println(status.stream().anyMatch(offileStatusPredicate));
	}
	
	public static void allMatch() {
		List<String> status = Arrays.asList("offline","offline","offline");
		Predicate<String> offileStatusPredicate = statusList -> statusList.equalsIgnoreCase("offline");
		System.out.println(status.stream().allMatch(offileStatusPredicate));
	}
	
	public static void noneMatch() {
		List<String> status = Arrays.asList("offline","ofline","offline");
		Predicate<String> offileStatusPredicate = statusList -> statusList.equalsIgnoreCase("ofline");
		System.out.println(status.stream().noneMatch(offileStatusPredicate));
	}
	
	public static void streamProblems() {
		int []arr1 = {2,7,3,0,4};
		int []arr2 = {1,16,6,5,13};
		
		int total = IntStream.concat(IntStream.of(arr1), IntStream.of(arr2))
		                          .reduce((n1,n2)->n1+n2).getAsInt();
		System.out.println(total);
		
		List<Integer> mergeAndSort =  IntStream.concat(IntStream.of(arr1), IntStream.of(arr2))
		                                       .boxed()
		                                       .sorted((n1,n2) -> n1-n2)
		                                       .collect(Collectors.toCollection(ArrayList::new));
		System.out.println(mergeAndSort);
		
		List<Integer> list1 = Arrays.asList(2,7,3,0,4);
		List<Integer> list2 = Arrays.asList(1,16,6,5,13);
		
		Stream.concat(list1.stream(), list2.stream())
		      .sorted((n1,n2) -> n2-n1)
		      .forEach(num ->System.out.print(num+" "));
		System.out.println();
		
		List<Integer> list = Arrays.asList(1,1,16,6,5,13,6,3,8,1,0,3,6,2,8,3);
		
		Map<Long,List<Integer>> gp = list.stream()
		                           .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		                           .entrySet()
		                           .stream()
		                           .collect(Collectors.groupingBy(
		                        		    Map.Entry::getValue,
		                        		    Collectors.mapping(Map.Entry::getKey,Collectors.toList())))
		                           .entrySet()
		                           .stream()
		                           .collect(Collectors.toMap(
		                        		        Map.Entry::getKey, 
		                        		        entry -> entry.getValue().stream()
		                                                                 .sorted(Comparator.reverseOrder())
                                                                         .collect(Collectors.toList()))
		                            );
		
		
		Map<Long, List<Integer>> gp2 = list.stream()
			    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // First grouping by element, counting occurrences
			    .entrySet()
			    .stream() // Convert the entry set to a stream
			    .collect(Collectors.groupingBy(
			        Map.Entry::getValue, // Group by the count (Long value)
			        TreeMap::new, // Keep keys sorted in ascending order (TreeMap ensures this)
			        Collectors.mapping(Map.Entry::getKey, Collectors.toList()) // Collect the keys into lists
			    ))
			    .entrySet()
			    .stream() // Stream over the entry set of the result
			    .collect(Collectors.toMap(
			        Map.Entry::getKey, // Keep the original count as key
			        entry -> entry.getValue().stream().sorted().collect(Collectors.toList()) // Sort the list of integers (values) here
			    ));
		System.out.println(gp);
		     
	}
	
	public static void main(String[] args) {
		streamProblems();
	}

}
