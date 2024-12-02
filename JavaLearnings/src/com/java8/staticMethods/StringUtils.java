package com.java8.staticMethods;

@FunctionalInterface
public interface StringUtils {
	public static String upperCase(String input) {
		return input.toUpperCase();
	}
	public static String lowerCase(String input) {
		return input.toLowerCase();
	}
	
	public String bothUppperAndLowerCase(String input);
}
