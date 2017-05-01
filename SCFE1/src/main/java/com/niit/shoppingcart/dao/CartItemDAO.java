package com.niit.shoppingcart.dao;

import com.niit.shoppingcart.domain.Cart;
import com.niit.shoppingcart.domain.CartItem;

public interface CartItemDAO {

	void addCartItem(CartItem cartItem);

	void removeCartItem(CartItem cartItemId);

	void removeAllCartItems(Cart cart);

	CartItem getCartItem(int cartItemId);
}
