package com.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class ReflectionApiEx {

	public static void main(String[] args) throws ClassNotFoundException {
	 Class<?> cls =	Class.forName("com.java8.staticMethods.LinkedListReverse");
	 Constructor<?> [] consArr = cls.getConstructors(); // gives default constructor
	 System.out.println(consArr.length);
	 
	 Constructor<?> [] declCons = cls.getDeclaredConstructors(); // return all constructor
	 System.out.println(declCons.length);
	 
	 for(Constructor<?> cons:declCons) {
		 //System.out.println(cons.getParameterCount());
		 System.out.println(Modifier.toString(cons.getParameterCount()));
	 }
	 
	}

}
