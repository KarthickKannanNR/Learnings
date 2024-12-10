package com.java.concepts;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//EnumPractice cow =EnumPractice.COW;
		//cow.sound();
		
		String str1 = "hello";
        String str2 = "hello";
        
        String str3 = new String(str1.intern());
        System.out.println(str1==str3);
	}

}
