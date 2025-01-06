package com.springboot.entity;

import java.math.BigDecimal;

import org.hibernate.annotations.Formula;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String description;
	private BigDecimal price;
	
	/*
	 * @Formula("price -(price * 10/100)") private double priceAfterDiscount;
	 * 
	 * public double getPriceAfterDiscount() { return priceAfterDiscount; }
	 * 
	 * public void setPriceAfterDiscount(double priceAfterDiscount) {
	 * this.priceAfterDiscount = priceAfterDiscount; }
	 */

	public Product(String name, String description, BigDecimal price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public  Product() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
