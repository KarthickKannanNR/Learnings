package com.java8.staticMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class LinkedListReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(10, 2, 3, 4, 5));
        
	       ListIterator<Integer> iterator = list.listIterator(list.size());
	       int i = 0;
	       while(iterator.hasPrevious() && i <= list.size()/2) {
	    	   list.set(i, iterator.previous());
	    	   i++;
	       }
    	   System.out.println(list);
	   }

	}


