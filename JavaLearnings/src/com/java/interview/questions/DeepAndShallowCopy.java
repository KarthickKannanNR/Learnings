package com.java.interview.questions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ShallowCopy{
	
	public ShallowCopyChild getScChild() {
		return scChild;
	}

	public void setScChild(ShallowCopyChild scChild) {
		this.scChild = scChild;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	int id;
	String name;
	ShallowCopyChild scChild;
	
	ShallowCopy(int id,String name,ShallowCopyChild scChild){
		this.id = id;
		this.name = name;
		this.scChild = scChild;
	}
}

class ShallowCopyChild{
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	String name;
	
	ShallowCopyChild(String name){
		this.name = name;
	}
}

public class DeepAndShallowCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShallowCopyChild scChild = new ShallowCopyChild("scChild1");
		ShallowCopy sc = new ShallowCopy(1, "kk",scChild);
		ShallowCopy sc2 = new ShallowCopy(2, "ss", new ShallowCopyChild("scChild2"));
		scChild.setName("htyt");
		sc.setName("ss");
		sc.setScChild(scChild);
		System.out.println("sc :"+sc.getName() +"scChild1 : "+ sc.getScChild().getName());
		System.out.println("sc2 :"+sc.getName() +"scChild2 : "+ sc2.getScChild().getName());
		
		List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,56));
		List<Integer> list2 = new ArrayList<>(list1);
		
		


	}

}
