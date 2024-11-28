package com.telusko.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;


@RestController
public class ConsumerServices {
	
	public ConsumerServices(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	private RestTemplate restTemplate;
	

	@Autowired
	private IFeignClient feignClient;
	
	
	@GetMapping(path = "restTemplateUsers",produces = "application/json")
	public List<UserResponse> getSampleUsers(){
		return restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", List.class);
	}
	
	
	@GetMapping("getUserByFeign")
	public List<UserResponse> getUsersByFeign(){
		return feignClient.getUsers();
	}
	

}
