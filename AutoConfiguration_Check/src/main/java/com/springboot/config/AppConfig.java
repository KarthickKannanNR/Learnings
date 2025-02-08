package com.springboot.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@ConditionalOnClass(name = "com.springboot.config.ConfigClass")
public class AppConfig {

	@Bean
	@ConditionalOnBean(name = "DummyComponentChk")
	public ConfigClass configClass() {
		return new ConfigClass();
	}
}
