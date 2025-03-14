package com.java.concepts;

import java.util.Collections;
import java.util.TreeMap;

public class RecordClassRunner {

	public static void main(String[] args) {
		RecordClass rc = new RecordClass(18,"karthick");
		System.out.println(rc.age());
		RecordClass rc2 = new RecordClass(18,"karthick");
		System.out.println(rc.equals(rc2));
		
		TreeMap<Integer, String> treeMap =  new TreeMap<>((key1,key2) -> key2.compareTo(key1));
		treeMap.put(11, "akash");
		treeMap.put(1, "karthick");

		System.out.println(treeMap);
		
		
	}

}
