package com.java.practiceproblems;

import java.util.InputMismatchException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringPracticeProblems {
	
	 //in recursive way  
	 public static String reverseString(String str) {
	        if (str.isEmpty()) {
	            return str;
	        }
	        return reverseString(str.substring(1)) + str.charAt(0);
	}
	
	public static void reverseString2() {
		String name = "karthick knannan";
		String reversedstring = "";
		
		for(int i = name.length()-1;i>=0;i--) {
			reversedstring += name.charAt(i);
		}
		
		System.out.println(reversedstring);
	}

	public static void reverseString() {
		//reversing a whole word
		String name = "karthick kannan";
		int pos =1;
	    String first ="";
	    String last = "";
	    char []nameArr = new char[name.length()];
		
	    //my approach first comes in my mind
		for(int i=0;i< name.length()/2;i++) {
			first = name.split("")[i]; // k
			last = name.split("")[name.split("").length-pos];
			nameArr = name.toCharArray();
			nameArr[i] = Character.valueOf(last.charAt(0));
			nameArr[name.length()-pos] = Character.valueOf(first.charAt(0));
			name = String.valueOf(nameArr);
			pos++;
		}
		
		System.out.println(name);
	}
	
	
	public static void printOccurenceOfChar() {
		String input = "a2b3c4";
		String output = "";
		
		for(int i=0;i< input.length();i++) {
			char c = input.charAt(i);
			
			if(Character.isLetter(c)) {
				int count = 0;
				if(i+1 < input.length() && Character.isDigit(input.charAt(i+1))) {
					count = Character.getNumericValue(input.charAt(i+1));
				}
				
				for(int j=0;j<count;j++) {
					output+=c;
				}
			}
		}
		
		System.out.println(output);
	}
	
	public static void printOccurenceOfChar2() {
		String input = "a2b3c4";

		for(int i = 0;i<input.length();i++) {
			char c = input.charAt(i);
			int count = 0;
			if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
				
				if(i+1 < input.length() && input.charAt(i+1) > '0' && input.charAt(i+1) <= '9') {
					 count = input.charAt(i+1) - '0';
				}
				for(int j=0;j<count;j++) {
					System.out.print(c);
				}
			}else {
				System.out.print(Character.isLetter(c)?c:"");
			}
			
			
			System.out.print(" ");
		}
	}
	
	public static void extractDigit() {
		String input = "a2b3c44jhasd9sd574675asb sd67";
		for(int i =0;i<input.length();i++) {
			char ch = input.charAt(i);
			if(ch >= '0' && ch <= '9') {
				System.out.print (ch);
			}
		}
	}
	
	public static void extractSpecificValue() {
		String input = "Name=\"Ramesh Kumar\"CompanyName=\"Uniq Technologies\"Experience=\"14 Years\"";
		
		String userInput = "Name";
		if(input.indexOf(userInput) == -1) throw new InputMismatchException();
		String result = input.substring(input.indexOf(userInput)+userInput.length()+2,  
				                        input.indexOf(userInput)+userInput.length()+2
				                        +input.substring(input.indexOf(userInput)+userInput.length()+2).indexOf("\""));  
		System.out.println(result);
				
	}
	
	
	public static void main(String[] args) {
		/*
		 * String name = "karthick kannan"; System.out.println(reverseString(name));
		 */
		
		extractSpecificValue();
	}

}
