package com.programmingtechie.api_gateway.service;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouteValidator {

	public static List<String> openEndpoints = List.of("/auth/login","/auth/create","/eureka");
	
	public Predicate<ServerHttpRequest> request = request ->{
	 	                                                 return openEndpoints.stream()
	 	                                                                     .noneMatch(uri -> request.getURI().getPath().contains(uri));
	                                              };
	
}
