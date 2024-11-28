package com.java8.staticMethods;

public class Client implements StringUtils{

	public static String lowerCase(String input) {
		return input.toLowerCase();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringUtils.lowerCase("karthick");
		Client.lowerCase("Karthick");
		StringUtilsImplemets impl = new StringUtilsImplemets();
		System.out.println(impl.lowerCase("KARTHICK"));
		
		
		
		
	}

	@Override
	public String bothUppperAndLowerCase(String input) {
		// TODO Auto-generated method stub
		return null;
	}

}


