package com.java.designPatterns;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PatternCheckMain {

	public static void patterPrint() {
		int row = 5;
		
		for(int i=1;i<=5;i++) {
			for(int j =0;j<=i;j++) {
				System.out.print(row-j+1);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		String s = "kkhhub";
		Map<String,Long> freq = Stream.of(s.split("")).peek(System.out::print)
				.map(c -> c.toString())
		                          .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		System.out.println(freq);
		patterPrint();
	}

}
