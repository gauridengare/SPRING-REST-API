package com.rest.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.demo.model.CustomerCart;

@Transactional
@Service
public class CustomerDAOImp implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public List<CustomerCart> getAllCartItems() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<CustomerCart> theQuery = currentSession.createQuery("from CustomerCart", CustomerCart.class);
		List<CustomerCart> customers = theQuery.getResultList();
		return customers;
	}

	public void saveCustomerItem(CustomerCart theCustomer) {

	}

	public List<CustomerCart> getCustomerCart(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<CustomerCart> theQuery = currentSession.createQuery("from CustomerCart where userId =: id");
		theQuery.setParameter("id", theId);
		List<CustomerCart> customers = theQuery.getResultList();
		return customers;
	}

	public void deleteCustomerCartItem(int theId) {

	}

}
