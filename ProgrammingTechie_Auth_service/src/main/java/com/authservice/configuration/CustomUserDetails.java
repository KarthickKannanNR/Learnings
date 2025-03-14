package com.authservice.configuration;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.authservice.entity.UserInfo;

public class CustomUserDetails implements UserDetails{

	private String userName;
	private String password;
	
	public CustomUserDetails(UserInfo userInfo) {
		this.userName = userInfo.getName();
		this.password = userInfo.getPassword();
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

}
