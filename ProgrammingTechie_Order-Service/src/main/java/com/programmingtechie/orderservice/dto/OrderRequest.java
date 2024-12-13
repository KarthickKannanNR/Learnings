package com.programmingtechie.orderservice.dto;

import java.util.List;

public class OrderRequest {

	public List<OrderLineItemsDTO> getOrderlineItemsDTO() {
		return orderlineItemsDTO;
	}

	public void setOrderlineItemsDTO(List<OrderLineItemsDTO> orderlineItemsDTO) {
		this.orderlineItemsDTO = orderlineItemsDTO;
	}

	private List<OrderLineItemsDTO> orderlineItemsDTO;
}
