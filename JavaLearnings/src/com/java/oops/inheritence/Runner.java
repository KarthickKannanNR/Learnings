package com.java.oops.inheritence;

public class Runner {

	public static void main(Object... arge) {
		//it will not called
	}
	
	public static void main(String[] args) {
		Child c = new Child();
		c.eatBiriyani();
		c.eat();

		
		//only eat from parent class method was available
		Parent p = new Parent();
		p.eat();
		
		
		
		//only eat from parent class method was available
		Parent p2 = new Child();
		p2.eat();
		
		
		//we can't do like this. Compile time error will occur
		/*
		 * Child c2 = (Child) new Parent(); c2.eat(); c2.eatBiriyani();
		 */
		
	}

}
