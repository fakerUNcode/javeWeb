package com.bookshopping.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.bookshopping.entity.CartItem;

public interface CartDAO {
	public void addToCart(HttpSession session, int bid) throws Exception;   		//将商品添加至购物车
	public List<CartItem> getAllCartItems(HttpSession session); 	//获取购物车中所有商品的信息
	public void removeCartItem(HttpSession session, int pid) ;	//删除购物信息
	public void  modifyCartItem(HttpSession session, int pid,int quantity) ;	// 修改购物数量
	
	public double getCartCost(HttpSession session); 	//统计"确认购买"的商品的总价
	
}
