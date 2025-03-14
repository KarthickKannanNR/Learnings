package com.java8.predicateExample;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class predicateExamples {
	 static Predicate<String> SelectedInCampusInterview ;
     static Predicate<String> degreeCompleted ;
     static Predicate<Integer> negatePredicate ;
	
	static void andExample() {
		SelectedInCampusInterview = interviewStatus -> interviewStatus.equalsIgnoreCase("yes");
		degreeCompleted = degreeStatus -> degreeStatus.equalsIgnoreCase("yes");
		
		System.out.println(SelectedInCampusInterview.and(degreeCompleted).test("Yes"));
	}
	
	static void orExample() {
		SelectedInCampusInterview = interviewStatus -> interviewStatus.equalsIgnoreCase("yes");
		degreeCompleted = degreeStatus -> degreeStatus.equalsIgnoreCase("no");
		System.out.println(SelectedInCampusInterview.or(degreeCompleted).test("yes"));
	}
	
	
	static void negateExample() { 
		//gives opposite result
		negatePredicate = age -> age>18;
		System.out.println(negatePredicate.negate().test(17));
	}
	
	static void forEachExample() {
		List<Integer> numList  = Arrays.asList(1,2,3,4,5,6);
		
		Consumer<Integer> printConsumer = list -> System.out.println(list);
		numList.forEach(printConsumer);
	}
	
	public static void biPredicateEx() {
		BiPredicate<String, String> nameNullChk = (fName,lName) -> fName.length()>0 && lName.length()>0;
		System.out.println("BiPredicate "+nameNullChk.test("karthick", "kannan"));
		System.out.println("BiPredicate and "+nameNullChk.and((fName,lName) -> fName.length()>0 && lName.length()>0).test("", "kannan")); 
		
	}
	
	public static void biConsumerEx() {
		BiConsumer<Integer, Integer> add = (a,b)-> System.out.println(a==b);
		add.andThen((a,b)->System.out.println(a*b)).accept(2, 3);
	}
	
	
    public static void optional() {
    	List<String> names = List.of("karthick", null, "akash");

    	List<String> nonNullNames = names.stream()
    	                                 .map(Optional::ofNullable)  // Wrap each value in Optional
    	                                 .flatMap(Optional::stream)  // Extract non-null values
    	                                 .map(String::toUpperCase)
    	                                 .collect(Collectors.toList());

    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		biPredicateEx();
	}

}
