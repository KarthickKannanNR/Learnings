package com.java.interview.questions;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class AP_IQ{
	
	
	public static void streams() {
		
		List<Employee> details = new ArrayList<>(Arrays.asList(

	            new Employee(1, "Alice", 67000,"Active"),

	            new Employee(2, "Bob", 57000 ,"Inactive"),

	            new Employee(3, "Charlie", 82000,"Active"),

	            new Employee(4, "David", 49000,"Inactive"),

	            new Employee(5, "Eve", 42270,null)

	        ));
		
		
	Map<String, List<Employee>> empByStatus = details.stream()
			                                         .collect(Collectors.groupingBy(emp -> Optional.ofNullable(emp.getStatus()).orElse("no status")));
	//System.out.println(empByStatus);
	
	HashMap<String, Employee> empByStatu = new HashMap<>();
	empByStatu.put(null, new Employee(5, "Eve", 42270,null));
	empByStatu.put(null, new Employee(4, "David", 49000,"Inactive"));
	
	System.out.println(empByStatu);

	 
	}
	
	public static void getCombinationOfSum() {
		int []arr = new int[]{3, 6, 8, -8, 10, 8 };
		String []pairArr = new String[arr.length];
		//{"6:10" , ""}
		int matchNum = 16;
		int count =0;
		for(int i=0;i<arr.length;i++){
			for(int j=i;j<arr.length;j++){
				if(arr[i]+arr[j]==matchNum){
					pairArr[count] = arr[i]+":"+arr[j];
					count++;
				}
			}
		}
		
		Arrays.asList(pairArr).stream()
		.forEach(System.out::println);
	}

	public void m1(StringBuffer s) {

	}

	public void m1(String s) {

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//getCombinationOfSum();
		//AP_IQ obj = new AP_IQ();
		streams();
	}
	

}
