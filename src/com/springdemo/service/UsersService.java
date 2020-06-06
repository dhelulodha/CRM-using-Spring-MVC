package com.springdemo.service;

import com.springdemo.entity.Users;

public interface UsersService {
	
	public boolean saveUser(Users theusers);
	
	public boolean validateUser(String uname,String pass);

}
