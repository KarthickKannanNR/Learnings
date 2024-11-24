package com.java8.exceptionHandling;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

class CustomException extends Exception{
	String message;
	CustomException(String message){
		this.message = message;
	}
}
public class ExceptionHandlingExample {
	
	public static void calculate() throws CustomException{
		try {
			int a = 5/2;
		}catch (Exception e) {
			throw new CustomException("custom exception message");
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			calculate();
			String a = "kk";
			String b = "kk";
			String c = new String("kk");
			System.out.println(a==b);
			System.out.println(a==c);
			
			System.out.println(a.equals(b));
			System.out.println(a.equals(c));
			
			System.out.println(a.compareTo(b));
			System.out.println(a.compareTo(c));
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			throw new Exception();
		}
	}
	


}
