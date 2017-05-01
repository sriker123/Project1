package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CustomerOrderDAO;
import com.niit.shoppingcart.domain.Cart;
import com.niit.shoppingcart.domain.CartItem;
import com.niit.shoppingcart.domain.CustomerOrder;



@Repository("customerorderDAO")
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private CartDAO cartDao;

	public void addCustomerOrder(CustomerOrder customerOrder) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.saveOrUpdate(customerOrder);
		session.getTransaction().commit();
		session.flush();
		session.close();

	}

	public double getCustomerOrderGrandTotal(int cartId) {
		double grandTotal = 0;
		Cart cart = cartDao.getCartByCartId(cartId);
		List<CartItem> cartItems = cart.getCartItems();

		for (CartItem item : cartItems) {
			grandTotal += item.getTotalPrice();
		}

		return grandTotal;
	}

}
