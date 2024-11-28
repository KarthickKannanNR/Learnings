package com.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


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
	public static void main(String[] args) {
		noneMatch();
	}

}
