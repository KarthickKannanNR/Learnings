package com.java8.cloneable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class CloneExample implements Cloneable{
	
	private int id;
	
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		CloneExample obj =  new CloneExample();
		obj.id = 10;
		
		CloneExample obj2 = obj.clone();
		System.out.println(obj2.id);
		
		System.out.println(obj == obj2);
		
	    List<Integer> numbers = Arrays.asList();	
	    
	    
	        
	   }
	
	@Override
	public CloneExample clone() throws CloneNotSupportedException {
		return (CloneExample) super.clone();
	}

}
