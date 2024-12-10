package com.java.concepts;

import java.io.IOException;

public class StringConcepts {
	
	
	public static void intern() {
		String s = "Sachin";  
		s.concat(" Tendulkar").intern();
		System.out.println(s);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		stringbuilder();
		 Runtime.getRuntime().exec("notepad");
	}
	
	public static void stringbuffer() {
		StringBuffer s1 = new StringBuffer("kk");
		StringBuffer s2 = new StringBuffer("kk");
		System.out.println(s1.toString().equals(s2.toString()));
	}
	
	public static void stringbuilder() {
		StringBuilder sb = new StringBuilder("kk");
		StringBuilder sb2 = new StringBuilder("kk");
		System.out.println(sb==sb2);
		System.out.println(sb.equals(sb2));
		System.out.println(sb.toString().equals(sb2.toString()));
	}

}
