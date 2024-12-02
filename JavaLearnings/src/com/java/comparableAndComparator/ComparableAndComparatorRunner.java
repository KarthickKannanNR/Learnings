package com.java.comparableAndComparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

class rollNumberCompare  implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getRollNo() < o2.getRollNo()) {
			return -1;
		}else if(o1.getRollNo() > o2.getRollNo()) {
			return 1;
		}else return 0;
	}
	
}

public sealed class ComparableAndComparatorRunner permits StreamsPracticePrograms{

	public static void comparable() {
		
		List<Student> students = studentList();
		Collections.sort(students);
		students.forEach(System.out::println);
	}
	
	public static void comparator() {
		List<Student> students = studentList();
		
		Comparator<Student> ageComparator = (Student o1, Student o2)-> o1.getAge()<o2.getAge()?-1:1;
		System.out.println("compare using roll number");
		Collections.sort(students, new rollNumberCompare());
		students.forEach(System.out::println);
		
		System.out.println("comparing using age");
		Collections.sort(students,ageComparator);
		students.forEach(System.out::println);
		
		Map<Integer, String> treemap = new TreeMap<>();
		treemap.put(5, "htfg");
		treemap.put(1, "jyg");
		treemap.put(3, "sadf");
		treemap.put(0, "aadf");
		System.out.println(treemap);
		
	}
	public static List<Student> studentList(){
		return Arrays.asList(
				new Student(4,18,"karthick"),
				new Student(2,16,"kannan"),
				new Student(21,12,"akash"),
				new Student(10,8,"babu"),
				new Student(1,13,"vishal")
				);
		 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		comparator();
		StringBuffer buffer = new StringBuffer();
	}

}
