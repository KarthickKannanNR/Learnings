package com.java.interview.questions;


public class AutoClosableExample implements AutoCloseable{
	
	private static AutoClosableExample obj ;
	

	public void createInstance() throws Exception {
		System.out.println("Create instance called");
	}
	
	public static void main(String[] args) throws Exception {
		obj = new AutoClosableExample();
		obj.createInstance();
	}

	@Override
	public void close() throws Exception {
		System.out.println("Auto close method called");
		if(obj != null) {
			obj = null;
		}
	}

}
