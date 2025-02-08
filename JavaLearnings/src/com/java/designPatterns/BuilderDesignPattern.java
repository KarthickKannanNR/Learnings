package com.java.designPatterns;

public class BuilderDesignPattern {

	public BuilderDesignPattern(int age2, String name2, int id2) {
		
	}
	public int getId() {
		return id;
	}
	public BuilderDesignPattern setId(int id) {
		this.id = id;
		return this;
	}
	public String getName() {
		return name;
	}
	public BuilderDesignPattern setName(String name) {
		this.name = name;
		return this;
	}
	public int getAge() {
		return age;
	}
	public BuilderDesignPattern setAge(int age) {
		this.age = age;
		return this;
	}
	private int id;
	private String name;
	private int age;
	
	public BuilderDesignPattern build() {
		return new BuilderDesignPattern(this.age,this.name,this.id);
	}
}
