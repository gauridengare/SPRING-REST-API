package com.rest.demo.service;

import java.util.List;


import com.rest.demo.model.CustomerCart;

public interface CustomerService {
	public List<CustomerCart> getAllCartItems();

	public void saveCustomerItem(CustomerCart theCustomer);

	public List<CustomerCart>  getCustomerCart(int theId);

	public void deleteCustomerCartItem(int theId);
}
