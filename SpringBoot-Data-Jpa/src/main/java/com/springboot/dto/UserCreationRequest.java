package com.springboot.dto;

import com.springboot.entity.PaymetVO;
import com.springboot.entity.UserVO;

public class UserCreationRequest {

	private UserVO user;
	
	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	private PaymetVO payment;

	public PaymetVO getPayment() {
		return payment;
	}

	public void setPayment(PaymetVO payment) {
		this.payment = payment;
	}
}
