package com.springboot.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

import com.springboot.entity.UserVO;
import com.springboot.service.UserService;

import jakarta.annotation.PostConstruct;

@Configuration
@EnableCaching
public class CacheConfig {

	@Autowired
	private CacheManager cacheManager;
	
	@Autowired
	UserService userService;
	
	@PostConstruct
	public void preLoadObjects() {
		Cache cache = cacheManager.getCache("userCache");
		List<UserVO> users = userService.getAllUsers();
		cache.put("users", users);
	}
}
