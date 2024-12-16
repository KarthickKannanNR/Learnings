package com.programmingtechie.orderservice.feignconfig;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.programmingtechie.orderservice.dto.InventoryResponse;


@FeignClient("ProgrammingTechieInventory-Service/api/inventory/")
public interface InventoryFeign {

	@GetMapping("checkStock")
	public List<InventoryResponse> checkStockAvailability(@RequestParam List<String> skuCode);
	
}
