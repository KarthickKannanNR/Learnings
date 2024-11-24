package com.telusko.demo;

import org.springframework.stereotype.Service;

@Service
public class DummyConfig {

	public void print() {
		System.err.println("dummyconfig print");
	}
}
