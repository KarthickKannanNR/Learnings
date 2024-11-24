package com.java8.functions;

import java.util.function.BiFunction;

public class BiFunctionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BiFunction<String, String, String> concatName = (firstName,lastname) -> firstName+" "+lastname;
		System.out.println(concatName.apply("karthick", "kannan"));
		
		BiFunction<Integer, Integer, Integer> add = (num1,num2) ->num1+num2;

	}

}
