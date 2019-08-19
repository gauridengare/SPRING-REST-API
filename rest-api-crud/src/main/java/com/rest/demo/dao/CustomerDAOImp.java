package com.rest.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

	public void saveCustomerItem(CustomerCart cartItem) {
Session currentSession = sessionFactory.getCurrentSession();
		
		// save/update the customer ... finally LOL
		currentSession.saveOrUpdate(cartItem);
	}

	public List<CustomerCart> getCustomerCart(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<CustomerCart> theQuery = currentSession.createQuery("from CustomerCart where userId =: id");
		theQuery.setParameter("id", theId);
		List<CustomerCart> customers = theQuery.getResultList();
		return customers;
	}
	
	public int check(int id,String course)
	{Session currentSession = sessionFactory.getCurrentSession();
	Query theQuery1 = currentSession.createQuery("from CustomerCart where userId =:customerId and course=:course");
	theQuery1.setParameter("customerId", id);
	theQuery1.setParameter("course", course);
	CustomerCart out = (CustomerCart) theQuery1.uniqueResult();
	int n=out.getQuantity();
	return n;
	}

	public void deleteCustomerCartItem(int theId,String course) {
Session currentSession = sessionFactory.getCurrentSession();
int quantity=check(theId,course);
if(quantity!=0)
{
	String queryString1 = "update CustomerCart set quantity = :q" + " where userId = :customerId and course = :course";
	Query theQuery = currentSession.createQuery(queryString1);
	theQuery.setParameter("customerId", theId);
	theQuery.setParameter("course", course);
	theQuery.setParameter("q", quantity-1);
	
	theQuery.executeUpdate();

}
else if(quantity==0)
	{
	Query theQuery = 
				currentSession.createQuery("delete from CustomerCart where userId =: customerId and course =: course");
		theQuery.setParameter("customerId", theId);
		theQuery.setParameter("course", course);
		
		theQuery.executeUpdate();
	}

	}
	
	

}
