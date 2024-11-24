package com.java8.methodReferenceEx;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

interface calculations{
	public void add(int a,int b);
}

interface calculations2{
	public void add(int a,int b);
}
public class MethodRefEx {

	private static void sum(int a,int b) {
		System.out.println(a*b);
	}
	
	public int multiply(int a,int b) {
		return a*b;
	}
	
	public static void methodRefUsingConstructor() {
		File file;
		List<String> carBrands = Arrays.asList("suzuki","honda","mahindra","tata","honda");
		System.out.println(carBrands);

		Set<String> distinctCarBrands  = new HashSet<>(carBrands);
		
		//using lambda
		Function<List<String>, Set<String>> distinctCarBrandsLamda = list -> new HashSet(list);
		//System.out.println(distinctCarBrandsLamda.apply(carBrands));
		
		//using methodReference
		Function<List<String>, Set<String>> distinctCarBrandsLamdaMr = HashSet::new;
		System.out.println(distinctCarBrandsLamdaMr.apply(carBrands));
	}
	public static void main(String[] args) {
		
		calculations calculate = (a,b) -> System.out.println(a+b);
	   calculate.add(1, 2);
	   
	   calculations calculate2 = MethodRefEx::sum;
	   calculate2.add(2, 3);
	   
	   calculations2 instanceMethodRef = new MethodRefEx()::multiply;
	   instanceMethodRef.add(2, 3);
	   
	   methodRefUsingConstructor();
	   
	  

	}

}
