package com.springboot.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

	static int i;
	static {
		i=8;
	}
	
	@Test
	 void test() {
		//assertEquals("java", "java");
		i=9;
		int [] exp = {4,3,2,1};
		int []actual = {3,1,2,4};
		Arrays.sort(actual);
		assertArrayEquals(exp, actual);
	}
	
	@BeforeAll
	public  void sort() {
		System.out.println("before all");
	}
	
	@Test
	 void test2() {
		//assertEquals("java", "java");
		
		int [] exp = {1,2,3,4};
		int []actual = {3,1,2,4};
		Arrays.sort(actual);
		assertArrayEquals(exp, actual);
	}

}
