package com.java8.staticMethods;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.TreeSet;

public class DiamondProblem {
	 
	static int num;
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	} 
	
    static
    {
        num = 4;
        System.out.println ("inside static block\\n");
        System.out.println ("a = " + num);
    }
    
    DiamondProblem(){
    	//this(100);
        System.out.println ("\\ninside constructor\\n");
        num = 10;
    }
    
    DiamondProblem(int i)
    {
        System.out.println ("inside 2nd contructor "+i);
        
    }
    
    public static void func()
    {
    	num = num + 1;
        System.out.println ("a = " + num);
        System.out.println("func called ");
    }
    
    public  void nonStaticMethod()
    {
    	num = num + 1;
        System.out.println ("a = " + num);
        System.out.println("func called ");
    }
    
    @FunctionalInterface
	interface A {
		
		public abstract void add(int r) throws Exception;
		
	    private void display() {
	        System.out.println("Display from A");
	    }
	    
	    default void display2() {
	    	display();
	        System.out.println("display2 from A");
	    }
	    
	}

	interface B extends A {
	    default void display() {
	        System.out.println("Display from B");
	    }
	}

	interface C extends A {
	    default void display() {
	        System.out.println("Display from C");
	    }
	}

	class D implements A,B, C {
	    @Override
	    public void display() {
	        // Explicitly resolving the ambiguity
	        B.super.display(); // or C.super.display();
	    }

		@Override
		public void add(int r) throws FileNotFoundException{
			System.out.println("add method called through constructor");
			
		}
	}
	
	public class E implements  C {
	  
		@Override
		public void add(int r) throws FileNotFoundException{
			System.out.println("add method called through constructor");
			
		}
	}
	
	//we can replace String[] with String... varargs	
	public static void main(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * Base b = new Derived(); Derived.show(); Derived derived = new Derived();
		 * derived.set(20); derived.get();
		 */
	     
		
		/*
		 * A a = DiamondProblem::new; a.add(7658765); DiamondProblem dp = new
		 * DiamondProblem(); dp.func();
		 */
	     //dp.varArgsDemo(5,8,9,0,1,"karthick",Arrays.asList(1,23));
		
			/*
			 * //calling static method will null reference(it is allowed) DiamondProblem obj
			 * =null; obj.func();
			 */
		
	System.out.println(new DiamondProblem().sumOfNNaturalNums(5));
	     
	     
	}
	
	public void instanceOfCheck() {
		System.out.println("instanceOf Check");
		int num=5;
		System.out.println(num);
		 Number b = 9;
		 Exception e = new Exception();
		 D d = new D();
		 A a = new E();
		 if(a instanceof D)
			 System.out.println(true);
		 else 
			 System.out.println(false);
		 	     
	}

	public void enumCheck() {
		 for (Season season : Season.values()) {
	            System.out.println(season + ": " + season.getDescription());
	        }
	}
	
	//varagrs introduced in java 5
	public void varArgsDemo(Object... a) {
		for(Object n:a) {
			System.out.println(n);
		}
	}
	
	public static void dataStructures(){
		try {
		TreeSet<Integer> ts = new TreeSet<>();
		ts.add(9);
		ts.add(8);
		System.out.println(ts);
		System.out.println(Season.WINTER.getDescription());
		
		HashSet<Integer> hashSet = new HashSet<>();
		hashSet.add(5);
		hashSet.add(10);
		hashSet.add(null);
		hashSet.add(0);
		
		hashSet.stream().sorted();
		System.out.println(hashSet);
		
		Hashtable<Integer, String> table = new Hashtable<>();
		table.put(1, "karthick");
		table.put(1, "kannan");
		//table.put(null, "kjyf");
		//table.put(2,null);
		table.put(1, "karthick");
		System.out.println(table);
		}catch(Exception e){
			throw e;
        }finally {
			System.out.println("finally block");
		}

	}
	
	public int sumOfNNaturalNums(int n) {
		if(n==0)
			return 1;
		
		return n * sumOfNNaturalNums(n-1);
	}
	
	public void dummyMethod() {
		try {
			
		} catch (Exception e) {
			
		}
	}
	
}

 enum Season {
    WINTER("Cold"), SPRING("Mild"), SUMMER("Hot"), FALL("Cool"), num;

    private String description;

    Season(String description) {
        this.description = description;
    }
    
    Season() {
    }

    public String getDescription() {
        return description;
    }
    
}