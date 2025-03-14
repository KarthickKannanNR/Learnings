package com.java.optionalExample;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class OptionalExample {

	public static void isPresentExample() {
		Optional<String>  optional = Optional.of("karthick");
		System.out.println("IsPresent() :"+optional.isPresent());
	}
	
	public static void isEmptyExample() {
		Optional<String>  optional = Optional.of("karthick");
		System.out.println("IsEmpty() :"+optional.isEmpty());
	}
	
	public static void empty() {
		Optional<String> emptyOptional = Optional.empty();
		System.out.println("Optional.empty() "+emptyOptional.orElseGet(()->"returned empty optional"));
	}
	
	public static void ifPresentExample() {
		Optional<String>  optional = Optional.ofNullable("karthick");
		Consumer<String> consumer = name -> System.out.println("If Present ".concat(Integer.valueOf(name.length()).toString()));
		optional.ifPresent(consumer);
	}
	
	public static void orElseExample() {
		Optional<String>  optional = Optional.ofNullable(null);
		Optional<Integer> intOptional = Optional.ofNullable(1);
		System.out.println("orElse() :"+optional.orElse("unable to process null value"));
		System.out.println("orElse() :"+intOptional.orElse(5));
	}
	
	public static void get() {
		Optional<String> optional = Optional.ofNullable("karthick");
		System.out.println(optional);
		System.out.println("get() :"+optional.get());
	}
	
	public static void orElseGetExample() {
		Optional<String> optional = Optional.ofNullable(null);
		System.out.println("orElseGet() :"+optional.orElseGet(()->String.valueOf(2*2)));
	}
	
	public static void orElseThrow() {
		 List<String> names = Arrays.asList("karthick");
		//List<String> names2 = names;
		names.remove("akash");
		System.out.println(names);
		//System.out.println(names2);
		Optional<String> optional = Optional.ofNullable(null);
		System.out.println("orElseThrow() :");
		System.out.println("orElseThrow() :"+optional.orElseThrow(() -> new StackOverflowError()));

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isPresentExample();
		isEmptyExample();
		ifPresentExample();
		orElseExample();
		get();
		orElseGetExample();
		//orElseThrow();
		empty();
	}
	

}
