package com.security.model;


public class Product {

	 int productId;
	 public Product(int productId, String name, int qty, int price) {
		super();
		this.productId = productId;
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	String name;
	 int qty;
	 int price;
}
