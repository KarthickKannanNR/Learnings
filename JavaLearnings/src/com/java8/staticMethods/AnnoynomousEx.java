package com.java8.staticMethods;

import java.util.function.Predicate;

public class AnnoynomousEx {

	public static void predicateTest(Predicate<Integer> evenChk) {
		System.out.println(evenChk.negate().test(11));
	}
	
	public static void main(String[] args) {
		predicateTest(num ->num%2==0);
	}
}
