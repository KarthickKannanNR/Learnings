package com.java.interview.questions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import com.java.interview.reduce.ReduceExample;

class Parent {
	
}

class Parent2 extends Parent{
	
}
public class AccentureInterviewQuestions extends ReduceExample{
		
	
	static int b=10;
	int a=b;
	static {
		System.out.println("static block executed");
		b=10;
	}
	
	 class check{
		
		void m1() {
			System.out.println("jygh");
			m2();
		}
		
		void m2() {
			System.out.println("jygh");
		}
	}
	
	 int i =0;
	class A{
		A(){
			
		}
		public void print(){

			
			try {
				Exception ef = new Exception();
				int i =9;
			}finally {
				
			} 
		}
	}
	
	class B extends A{
		
		 @Override
		 public void print() throws IndexOutOfBoundsException{
			
		}
	}
	
	public static void classNotFoundExceptionError() {
		try {
			Class.forName("com.oracle.jdbc.oracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ClassLoader.getSystemClassLoader().loadClass("uhsf.skufhsiughsef");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void iteratorAndListIterator() {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		
		Iterator<String> iterator = list.listIterator();
		
		//it will add k without any error but loop will run infinitely
		//when we try to ge the value using iterator.next() - concurrentModException will occur
		int count =1;
		/*
		 * while(iterator.hasNext()) { if(count==1) { list.add("jyug"); //It will throw
		 * illegalStateException //iterator.remove(); count++; }
		 * System.out.println(iterator.next()); }
		 */
		
		
		ListIterator<String> listIterator = list.listIterator();
		
		while(listIterator.hasNext()) {
//			listIterator.add("D");
            list.add("Z");
			System.out.println("Index "+listIterator.nextIndex()+" " +listIterator.next());
			if(!listIterator.hasNext()) {
				while(listIterator.hasPrevious()) {
					System.out.println(listIterator.previous());
				}
				break;
			}
		}
		
		
		LinkedList<String> linkList = new LinkedList<>();
		linkList.add("a");
		linkList.add("b");
		linkList.add("c");
		
		System.out.println("linkedListIterator");
		ListIterator<String> linkedListIterator = linkList.listIterator();
		while(linkedListIterator.hasNext()) {
			System.out.println(linkedListIterator.next());
			linkedListIterator.add("5");
		}
	}
	
	public static void tryCatchCheck() {
		
		try {
			try {
				System.out.println("inner try block");
				System.out.println(10/0);
			} catch (Exception e) {
				System.out.println("inner catch block");
				throw new ArithmeticException();
			}finally {
				System.out.println("inner finnaly block");
			}
			System.out.println("try block");
			System.out.println(10/0);
		}catch(Exception e) {
			System.out.println("catch block");
			e.printStackTrace();
			throw new ArithmeticException();
		}finally {
			System.out.println("finnaly block");
		}
	}
	

	public static void main(String[] args) {
		/*
		 * System.out.println("main method"); Number a = 10; AccentureInterviewQuestions
		 * obj = new AccentureInterviewQuestions(); Parent2 p = new Parent2();
		 * System.out.println(p instanceof Parent); ReduceExample re = new
		 * ReduceExample(); System.out.println(obj.num); Integer i = 10; int num = i;
		 * tryCatchCheck();
		 */
		
		iteratorAndListIterator();
	}
	

}
