package com.springdemo.dao;

import com.springdemo.entity.Users;

public interface UsersDAO {
	
	public boolean saveUser(Users theUsers);
	
	public boolean validateUser(String uname,String pass);

}
