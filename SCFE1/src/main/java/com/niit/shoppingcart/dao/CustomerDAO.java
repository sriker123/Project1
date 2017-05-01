package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Customer;



public interface CustomerDAO {

	void addCustomer(Customer customer);

	List<Customer> getAllCustomers();

	public Customer getCustomerByUsername(String username);
}
