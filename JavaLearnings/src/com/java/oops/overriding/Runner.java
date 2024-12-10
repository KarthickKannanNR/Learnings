package com.java.oops.overriding;

public class Runner {
	
	private int id;
	
	public Runner(int id) {
		this.id = id;
		call(this);
	}

	public void call(Runner runner) {
		runner.add();
	}
	
	public void add() {
		System.out.println("add called");
	}
	
	public static void main(String[] args) {
		Son son = new Son();
		son.work();
		
		Parent parent  = new Parent();
		parent.work();
		
		Parent parent2 = new Son();
		System.out.println(parent2.parentMethod().getClass().getName());
		
		String k = "asfd";
		if(k.charAt(0) > k.charAt(1)) {}
		
		System.out.println("Son "+son.parentMethod());
		System.out.println("parent :"+parent.parentMethod());
		 
		Runner runner  = new Runner(2);
		
	
	}

}
