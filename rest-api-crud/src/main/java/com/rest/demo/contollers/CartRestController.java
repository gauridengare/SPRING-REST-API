package com.rest.demo.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.demo.model.CustomerCart;
import com.rest.demo.service.CustomerService;

@RestController
@RequestMapping("/rest")
public class CartRestController {
	@Autowired
	private CustomerService customerService;
	
	//all cart items of all customers
	@GetMapping("/allcart")
	public List<CustomerCart> getCustomers()
	{
		return customerService.getAllCartItems();
	}
	
	//testing api
	@GetMapping("/test")
	public String test()
	{
		return "Success!";
	}
	
	//cart items of indivisual customer
	@GetMapping("/getCustomerCart/{userId}")
	public List<CustomerCart> getCustomerCart(@PathVariable int userId)
	{
		return customerService.getCustomerCart(userId);
	}
	
	@DeleteMapping("/deleteCustomer/{userId}/{course}")
	public void deleteCustomer(@PathVariable int userId,@PathVariable String course)
	{
		 customerService.deleteCustomerCartItem(userId,course);
		
	}
	
	@PostMapping("/addCartItem")
	public CustomerCart addCustomer(@RequestBody CustomerCart cartItem)
	{
		cartItem.setId(0);
		 customerService.saveCustomerItem(cartItem);
		 return cartItem;
	}
}
