package com.java8.exceptionHandling;



class CustomException extends Exception{
	String message;
	CustomException(String message) throws ArithmeticException{
		this.message = message;
	}
}
public class ExceptionHandlingExample{
	
	
	public static void calculate() throws CustomException{
		try {
			int a = 5/0;
		}catch (final Exception e) {
			//e.printStackTrace();
			System.out.println("catch block");
			throw e;
			//Exception e2 =  e;
			//throw new CustomException("custom exception message");
		}finally {
			System.out.println("finally block");
		}
	}
	
	public static void stringCompare() {
		String a = "kk";
		String b = "kk";
		String c = new String("kk");
		System.out.println(a==b);
		System.out.println(a==c);
		
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));
		
		System.out.println(a.compareTo(b));
		System.out.println(a.compareTo(c));
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			calculate();
			
		} catch (CustomException  | ArithmeticException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			//throw new Exception();
		}
	}
	


}
