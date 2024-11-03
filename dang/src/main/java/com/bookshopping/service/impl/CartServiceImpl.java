package com.bookshopping.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.bookshopping.dao.CartDAO;
import com.bookshopping.entity.CartItem;
import com.bookshopping.service.CartService;


@Service("cartService")
public class CartServiceImpl implements CartService{

	@Resource(name="cartDAO")
	private CartDAO cartDao;
	
	public void addToCart(HttpSession session, int bid) throws Exception {
		cartDao.addToCart(session, bid);
	}

	public List<CartItem> getAllCartItems(HttpSession session) {
		return cartDao.getAllCartItems(session);
	}
	public double getCartCost(HttpSession session) {
		return cartDao.getCartCost(session);
	}
	
	public void modifyCartItem(HttpSession session, int bid, int quantity) {
		cartDao.modifyCartItem(session, bid, quantity);
		
	}

	public void removeCartItem(HttpSession session, int bid) {
		cartDao.removeCartItem(session, bid);
	}

	

}
