package com.rest.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.demo.dao.CustomerDAO;
import com.rest.demo.model.CustomerCart;

@Transactional
@Service
public class CustomerServiceImp implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;

	public List<CustomerCart> getAllCartItems() {
		return customerDAO.getAllCartItems();
	}

	public void saveCustomerItem(CustomerCart theCustomer) {
		customerDAO.saveCustomerItem(theCustomer);
	}

	public List<CustomerCart> getCustomerCart(int theId) {
		return customerDAO.getCustomerCart(theId);
	}

	public void deleteCustomerCartItem(int theId,String course) {
		customerDAO.deleteCustomerCartItem(theId,course);

	}

}
