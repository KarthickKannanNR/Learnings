package com.programmingtechie.inventoryService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_inventory")
public class Inventory {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String skuCode;
    private Integer quantity;
    
    public Inventory() {}
    
    public Inventory(String skuCode,Integer qty) {
    	this.skuCode = skuCode;
    	this.quantity = qty;
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
