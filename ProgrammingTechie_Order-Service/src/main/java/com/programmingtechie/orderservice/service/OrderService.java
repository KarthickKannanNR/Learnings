package com.programmingtechie.orderservice.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.programmingtechie.orderservice.dto.OrderLineItemsDTO;
import com.programmingtechie.orderservice.dto.OrderRequest;
import com.programmingtechie.orderservice.model.Order;
import com.programmingtechie.orderservice.model.OrderLineItems;

@Service
public class OrderService {

	
	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNUmber(UUID.randomUUID().toString());
		orderRequest.getOrderlineItemsDTO().stream().map(or -> maptoDTO(or)).toList();
	}
	
	public OrderLineItems maptoDTO(OrderLineItemsDTO orderlineItemsDTO) {
		OrderLineItems oi = new OrderLineItems();
		oi.setPrice(orderlineItemsDTO.getPrice());
		oi.setQuatity(orderlineItemsDTO.getQuatity());
		oi.setSkuCode(orderlineItemsDTO.getSkuCode());
		return oi;
	}
}
