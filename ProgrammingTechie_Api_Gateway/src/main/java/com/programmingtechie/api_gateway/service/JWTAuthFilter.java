package com.programmingtechie.api_gateway.service;


import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;

import com.programmingtechie.api_gateway.util.JWTTokenUtil;

public class JWTAuthFilter extends AbstractGatewayFilterFactory<JWTAuthFilter.Config>{
	
	@Autowired
	RouteValidator validator;
	@Autowired
	JWTTokenUtil jwtUtil;
	
	public JWTAuthFilter() {
		super(Config.class);
	}
	
	class Config{
		
	}

	@Override
	public GatewayFilter apply(Config config) {
		return ((exchange,chain) ->{
			if(validator.request.test(exchange.getRequest())) {
				if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
					throw new RuntimeException("Missing Authorization Headers");
				}
				
				String header = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
				if(header != null && header.contains("Bearer ")) {
					header = header.substring(6);
				}
				
				try {
					jwtUtil.validateToken(header);
				}catch (Exception e) {
					
				}
			}
			return chain.filter(exchange);
		});
	}

}
