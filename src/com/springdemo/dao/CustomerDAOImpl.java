package com.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.entity.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to session factory
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//create query..sort by last name
		Query<Customer> theQuery=
				currentSession.createQuery("from Customer order by lastName",Customer.class);
		
		//get result query by executing it
		List<Customer> customers=theQuery.getResultList();
		
		//return list of customers retrieved
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		//get current hibernate session 
		Session currentSession= sessionFactory.getCurrentSession();
		
		
		
		//save/update the customer to database
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		
		//get the current hibernate session
		Session currentSession= sessionFactory.getCurrentSession();
		
		//retrive from database with primary key
		Customer theCustomer =currentSession.get(Customer.class,theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		//get the current hibernate session
				Session currentSession= sessionFactory.getCurrentSession();
				
				//delete from database with primary key
				Query theQuery=
						currentSession.createQuery("delete from Customer where id =:customerId");
				theQuery.setParameter("customerId",theId);
				
				theQuery.executeUpdate();
		
	}

}
