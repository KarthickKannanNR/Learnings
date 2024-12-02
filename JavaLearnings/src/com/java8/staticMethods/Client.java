package com.java8.staticMethods;

import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.TreeSet;

public class Client implements StringUtils{
	
	int num = 1;

	public static String lowerCase(String input) {
		return input.toLowerCase();
	}
	
	public void lowerCase() {
		num=9;
	}
	
	public static void main(String[] args) {
		String name = new String("KK");
		String name2 = new String("KK");

		System.out.println(name.intern() == name2.intern());		
		
		// TODO Auto-generated method stub
		StringUtils.lowerCase("karthick");
		Client.lowerCase("Karthick");
		StringUtilsImplemets impl = new StringUtilsImplemets();
		System.out.println(impl.lowerCase("KARTHICK"));
		name = null;
		System.out.println(name);
		
		
		IdentityHashMap<Object, String> map = new IdentityHashMap<>();

        String a = new String("test");
        String b = new String("test");
        
        String hf = "kk"; 

        map.put(a, hf);
        map.put(a, hf);

        System.out.println(map.get(a)); // Output: Object A
        System.out.println(map.get(b)); // Output: Object B
        System.out.println(map.size());  
		
	}

	@Override
	public String bothUppperAndLowerCase(String input) {
		// TODO Auto-generated method stub
		return null;
	}

}


