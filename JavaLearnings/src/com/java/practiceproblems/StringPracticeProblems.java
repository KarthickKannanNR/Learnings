package com.java.practiceproblems;

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
	
	public static void main(String[] args) {
		 String name = "karthick kannan";
	     System.out.println(reverseString(name));  
	}

}
