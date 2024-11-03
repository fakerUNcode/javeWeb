package com.bookshopping.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.bookshopping.entity.CartItem;

public interface CartService {
	
	public void addToCart(HttpSession session, int bid) throws Exception;
	
	public List<CartItem> getAllCartItems(HttpSession session);
	
	public void modifyCartItem(HttpSession session, int id, int quantity);
	
	public void removeCartItem(HttpSession session, int pid);
	
	public double getCartCost(HttpSession session);

}
