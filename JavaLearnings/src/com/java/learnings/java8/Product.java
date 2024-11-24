package com.java.learnings.java8;

public class Product {

	    int id;  
	    String name;  
	    float price;  
	    public Product(int id, String name, float price) {  
	        this.id = id;  
	        this.name = name;  
	        this.price = price;  
	    }  
	    
	    public Product() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Product [id=" + id + ", name=" + name + ", price=" + price + ", getClass()=" + getClass()
					+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}

		public int add(int a ,int b) {
	    	return a+b;
	    }
}
