package com.java.datastructures_and_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public class CollectionsCheck {
	
	public static void list() {
		ArrayList<String> names = new ArrayList<>();
		names.add("karthick");
		names.add("akash");
		names.add("alamelu");
		names.add("aka");
		
		
		
		//names.forEach(System.out::println);
		//System.out.println(names.lastIndexOf("alamelu")); 
		//System.out.println(names.indexOf("alamelu"));
		//names.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		
		Iterator<String> iterator1 = names.iterator();
		while(iterator1.hasNext()) {
			System.out.println(iterator1.next());
		}
		
		String[] stringArr = names.toArray(new String[names.size()]);
		names.addAll(Arrays.asList("karthick",null));
		names.clear();
//		while(iterator1.hasNext()) {
//			System.out.println(iterator1.next());
//		}

		/*
		 * Iterator<String> iterator2 = names.iterator(); while(iterator2.hasNext()) {
		 * System.out.println(iterator1.next()); }
		 */
		names.forEach(System.out::println);
		names.get(9);
		
	}
	
	
	
	public static void hashMap() {
		Map<Integer, String> map = new HashMap();
		map.put(2, "a");
		map.put(10, "a");
		map.put(3, "a");
		map.put(120, "a");
		System.out.println(map);
		
	    int i = Integer.valueOf("1");
	    System.out.println(i);
	}
	
	public static void hashTable() {
		Hashtable<String, Integer> hastable = new Hashtable<>();
		hastable.put(null, 1);	
	}
	
	public static void hashSet() {
		Set<String> hasset = new HashSet<>();
		hasset.add("karthick");
		hasset.add("akash");
		hasset.add("suriya");
		hasset.add("kiruba");
		hasset.add("nethaji");
		hasset.add("ajees");
		hasset.add("berbin");

		System.out.println(hasset);

	}

	public static void linkedList() {
		LinkedList<String> list = new LinkedList<>();
		list.add("ani");
		list.add("akash");
		
		//list.stream().sorted((list1,list2) -> list1.compareTo(list2)).forEach(System.out::println);
		Collections.sort(list,(val1,val2) -> val1.charAt(0) < val2.charAt(0) ?1:-1);
		System.out.println(list);

	}
	

	public static void main(String[] args) {
		hashMap();
	}
}
