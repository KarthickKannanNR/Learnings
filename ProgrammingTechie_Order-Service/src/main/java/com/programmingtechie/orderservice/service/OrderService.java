package com.programmingtechie.orderservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programmingtechie.orderservice.dto.OrderLineItemsDTO;
import com.programmingtechie.orderservice.dto.OrderRequest;
import com.programmingtechie.orderservice.model.Order;
import com.programmingtechie.orderservice.model.OrderLineItems;
import com.programmingtechie.orderservice.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNUmber(UUID.randomUUID().toString());
	    List<OrderLineItems> orderList =  orderRequest.getOrderlineItemsDTO().stream().map(this::maptoDTO).toList();
	    order.setOrderLineItems(orderList);
	    orderRepository.save(order);
	}
	
	public OrderLineItems maptoDTO(OrderLineItemsDTO orderlineItemsDTO) {
		OrderLineItems oi = new OrderLineItems();
		oi.setPrice(orderlineItemsDTO.getPrice());
		oi.setQuatity(orderlineItemsDTO.getQuantity());
		oi.setSkuCode(orderlineItemsDTO.getSkuCode());
		return oi;
	}
}
