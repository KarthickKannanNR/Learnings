package com.security.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.security.model.UserInfo;


public class UserInfoUserDetails implements UserDetails{
	
	private String name;
	private String password;
	private List<GrantedAuthority> authorities;
	
	 
	public UserInfoUserDetails(UserInfo user){
		this.name = user.getName();
		this.password = user.getPassword();
		this.authorities = Arrays.stream(user.getRole().split(","))
				           .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return name;
	}

}
