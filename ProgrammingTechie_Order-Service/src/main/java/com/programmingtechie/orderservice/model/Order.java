package com.programmingtechie.orderservice.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String orderNumber;
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderLineItems> orderLineItems;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOrderNUmber() {
		return orderNumber;
	}
	public void setOrderNUmber(String orderNUmber) {
		this.orderNumber = orderNUmber;
	}
	public List<OrderLineItems> getOrderLineItems() {
		return orderLineItems;
	}
	public void setOrderLineItems(List<OrderLineItems> orderLineItems) {
		this.orderLineItems = orderLineItems;
	}
}
