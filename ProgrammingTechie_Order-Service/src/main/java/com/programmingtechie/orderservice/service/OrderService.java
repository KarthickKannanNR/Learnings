package com.programmingtechie.orderservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.programmingtechie.orderservice.dto.InventoryResponse;
import com.programmingtechie.orderservice.dto.OrderLineItemsDTO;
import com.programmingtechie.orderservice.dto.OrderRequest;
import com.programmingtechie.orderservice.feignconfig.InventoryFeign;
import com.programmingtechie.orderservice.model.Order;
import com.programmingtechie.orderservice.model.OrderLineItems;
import com.programmingtechie.orderservice.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	@Autowired
	private InventoryFeign inventoryFeign;
	
	public String placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNUmber(UUID.randomUUID().toString());
		List<OrderLineItems> orderList = orderRequest.getOrderlineItemsDTO().stream().map(this::maptoDTO).toList();
		order.setOrderLineItems(orderList);
		
		
		List<String> skuCodes =  orderList.stream().map(OrderLineItems::getSkuCode).toList();

		// call inventory service to check the product is in stock and then place order    ProgrammingTechie_Inventory-Service
		/*
		 * InventoryResponse[] inventoryResponse = webClientBuilder.build().get().uri(
		 * "http://ProgrammingTechieInventory-Service/api/inventory/checkStock",
		 * uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build()) .retrieve()
		 * .bodyToMono(InventoryResponse[].class).block();
		 * 	Boolean inStockStatus =  Arrays.stream(inventoryResponse).allMatch(InventoryResponse::isInStock);
		 */
		
	    List<InventoryResponse> inventoryResponse	=  inventoryFeign.checkStockAvailability(skuCodes);
	 	
		Boolean inStockStatus =  inventoryResponse.stream().allMatch(InventoryResponse::isInStock);
		
                 
		if (inStockStatus) {
			orderRepository.save(order);
			return "order placed successfully";
		}else {
			throw new IllegalArgumentException("This product is currently out of stock");
		}

	}

	public OrderLineItems maptoDTO(OrderLineItemsDTO orderlineItemsDTO) {
		OrderLineItems oi = new OrderLineItems();
		oi.setPrice(orderlineItemsDTO.getPrice());
		oi.setQuatity(orderlineItemsDTO.getQuantity());
		oi.setSkuCode(orderlineItemsDTO.getSkuCode());
		return oi;
	}
}
