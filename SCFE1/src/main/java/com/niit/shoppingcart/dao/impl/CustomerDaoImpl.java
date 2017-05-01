package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CustomerDAO;
import com.niit.shoppingcart.domain.Cart;
import com.niit.shoppingcart.domain.Customer;
import com.niit.shoppingcart.domain.User;



@Repository("customerDAO")
@Transactional
public class CustomerDaoImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// add a customer
	@SuppressWarnings("unused")
	public void addCustomer(Customer customer) {
		Session session = sessionFactory.openSession();

		customer.getUser().setEnabled(true);
		customer.getUser().setRole("User");
		String username = customer.getUser().getName();

		Cart cart = new Cart();
		customer.setCart(cart);
		cart.setCustomer(customer);

		session.save(customer);
		session.flush();
		session.close();

	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.openSession();
		List<Customer> customers = session.createQuery("from Customer").list();
		return customers;
	}

	public Customer getCustomerByUsername(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User where name=?");
		query.setString(0, username);
		User user = (User) query.uniqueResult();
		Customer customer = user.getCustomer();
		return customer;
	}

}
