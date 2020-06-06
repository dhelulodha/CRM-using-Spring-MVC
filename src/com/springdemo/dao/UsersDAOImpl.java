package com.springdemo.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.controller.CustomerController;
import com.springdemo.entity.Customer;
import com.springdemo.entity.Users;

@Repository
public class UsersDAOImpl implements UsersDAO {

	private static final Logger logger = Logger.getLogger(UsersDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean saveUser(Users theUsers) {
		
		Session currentSession= sessionFactory.getCurrentSession();
		try {
	
			boolean result;
			/*Query theQuery=
				currentSession.createQuery
				("select count(email) from Users u where email='"+theUsers.getEmail()+"'");
		Long num = (Long)theQuery.uniqueResult();*/
         
			Query<Users> theQuery=
					currentSession.createQuery("from Users where email='"+theUsers.getEmail()+"'",Users.class);
			
			//get result query by executing it
			List<Users> users=theQuery.getResultList();
			
			if(users.isEmpty())
		{
				
			currentSession.save(theUsers);
			result=true;
			System.out.println("*success*");
			logger.info("***** saved sucessfully*****");
			return result;
		}
			else 
			{   
				
				result=false;
				return result;
			}
		//save the customer to database
		
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		

	}

	@Override
	public boolean validateUser(String email, String pass) {
 
		Session currentSession= sessionFactory.getCurrentSession();
		
		boolean userFound = false;
		//Query using Hibernate Query Language
		String HQL_QUERY =" from Users as o where o.email='"+email+"' and o.password='"+pass+"'";
		Query<Users> query = currentSession.createQuery(HQL_QUERY,Users.class);
		//query.setParameter(0,email);
		//query.setParameter(1,pass);
		List<Users> list = query.list();

		if ((list != null) && (list.size() > 0)) {
			userFound= true;
		}

		return userFound;              

	}



}
