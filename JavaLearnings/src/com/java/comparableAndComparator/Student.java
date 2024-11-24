package com.java.comparableAndComparator;

import java.util.Objects;

public class Student implements Comparable<Student>{

	
	private int rollNo;
	public int getRollNo() {
		return rollNo;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", age=" + age + ", name=" + name + "]";
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public int getAge() {
		return age;
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, name, rollNo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return age == other.age && Objects.equals(name, other.name) && rollNo == other.rollNo;
	}
	public Student(int rollNo, int age, String name) {
		super();
		this.rollNo = rollNo;
		this.age = age;
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private int age;
	private String name;
	
	
	@Override
	public int compareTo(Student o) {
		if(this.age < o.age) {
			return -1;
		}else if(this.age > o.age) {
			return 1;
		}else return 0;
	}
}
