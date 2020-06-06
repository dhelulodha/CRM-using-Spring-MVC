package com.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.dao.UsersDAO;
import com.springdemo.entity.Users;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDAO usersDAO;
	
	@Override
	@Transactional
	public boolean saveUser(Users theUsers) {

        boolean result= usersDAO.saveUser(theUsers);
      
        return result;
	}

	@Override
	@Transactional
	public boolean validateUser(String uname, String pass) {
		boolean result=usersDAO.validateUser(uname, pass);
		return result;
	}



}
