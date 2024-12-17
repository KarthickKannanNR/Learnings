package com.springbootsecurity.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails{
	
	private UserInfo userInfo;

	public UserPrincipal(UserInfo user){
		this.userInfo=user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return  Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userInfo.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userInfo.getName();
	}

}
