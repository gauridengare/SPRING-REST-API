package com.rest.demo.dao;

import java.util.List;
import com.rest.demo.model.CustomerCart;

public interface CustomerDAO {
	public List<CustomerCart> getAllCartItems();

	public void saveCustomerItem(CustomerCart theCustomer);

	public List<CustomerCart>  getCustomerCart(int theId);

	public void deleteCustomerCartItem(int theId);
}
