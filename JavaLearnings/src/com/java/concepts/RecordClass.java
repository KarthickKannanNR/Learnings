package com.java.concepts;

public record RecordClass(int age,String name){
	
	
//  we can also define a construtor like this
//	public RecordClass(int age,String name){
//		this.age = 0;
//		this.name = "";
//	}
	
//	This type of constructor is used to additional validation while intializing
	public RecordClass{
		if(age < 18) {
			throw new IllegalArgumentException();
		}
	}
	
	

	public RecordClass(String name) {
	//  Below line is used for custom initialize the value	
		this(18,name);
	}
	
	public RecordClass(int age) {
		//  Below line is used for custom initialize the value	
			this(age,"karthick");
		}
	
	
}