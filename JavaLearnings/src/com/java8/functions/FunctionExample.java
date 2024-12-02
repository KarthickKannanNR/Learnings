package com.java8.functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionExample {
	
	public static void usingLambaWithFunctions() {
		Function<Integer, Double> usdToInr =  (usd) -> usd*81.5;
		System.out.println(usdToInr.apply(11)); 
	}
	
	public static void usingAnaoynomous() {
		Function<Integer, Double> usdToInr = new Function<Integer, Double>() {
			
			@Override
			public Double apply(Integer t) {
				// TODO Auto-generated method stub
				return t*81.56;
			}
		};
		System.out.println(usdToInr.apply(51));
	}
	
	public static void composeAndThen(){
		Function<Integer,Integer> resul1 = (input) ->{
			return input*2;
		};
		
		Function<Integer,Integer> resul2 = (input) ->{
			return input+2;
		};
		
		System.out.println(resul1.compose(resul2).apply(2));
	}
	
	public static void upperAndLowerBoundGeneric() {
		//lower bound
		List<Integer> numList = Arrays.asList(2,5,1,3,4,6,7,1);
		Consumer<Number> printList = input -> System.out.print(input+" ");
		numList.forEach(printList);
		
		Consumer<List<Integer>> printList2 = input -> System.out.print(input+" ");
		printList2.accept(numList);
	}
	
	public static void biFunctionEx() {
		BiFunction<Integer, Integer, Integer> sumBiFunc = (a,b) -> a*b;
		System.out.println(sumBiFunc.andThen(a -> a/2).apply(10, 10));
		
	}
	
	
	public static void main(String[] args) {
		FunctionExample.composeAndThen();
		FunctionExample.biFunctionEx();
	}
}
