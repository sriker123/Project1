package com.niit.shoppingcart.dao;

import com.niit.shoppingcart.domain.CustomerOrder;

public interface CustomerOrderDAO {

	void addCustomerOrder(CustomerOrder customerOrder);

	public double getCustomerOrderGrandTotal(int cartId);
}
