package com.java.oops;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import com.java.comparableAndComparator.Student;

class InheritenceRunner1 {
	  int i = 5;

	public static void main(String[] args) {
		Parent1 parent1 = new Child1();
		parent1.print();
		parent1.name();
		
	    Set<Student> ss = new HashSet<>();
	    Student s1 = new Student(1, 15, "karthick");
	    Student s2= new Student(1, 15, "karthick");
	    Student s3 = new Student(1, 15, "karthick");
	    Student s4 = new Student(1, 15, "karthick");
	    ss.add(s1);
	    ss.add(s2);
	    ss.add(s3);
	    ss.add(s4);
	    System.out.println(ss);
	    
	    Keyboard key =  new AdvKeyboard();
	    key.click3();
	    key.click();
	   
	    

	}
	
	public static void print() {
		InheritenceRunner1 oi = new InheritenceRunner1();
		oi.i = 6;
	}
	
	
	
}
class Keyboard{
	
	int key = 5;
	
	void click() {
		System.out.println("Keyboard click");
	}
	
	void click3() {
		System.out.println("Keyboard click");
	}
	
	void click3(int a) {
		System.out.println("Keyboard click3 "+ a);
	}

}

 class AdvKeyboard extends Keyboard{
	int key = 9;

	void click() {
		System.out.println(key);
		System.out.println("AdvKeyboard click");
	}
	
	void click2() {
		System.out.println("AdvKeyboard click2");
	}
}
