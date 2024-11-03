package com.bookshopping.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.bookshopping.dao.BookDAO;
import com.bookshopping.dao.CartDAO;
import com.bookshopping.entity.Book;
import com.bookshopping.entity.CartItem;

@Repository("cartDAO") 
public class CartDAOImpl implements CartDAO{
	
	@Resource(name="bookDAO")
	private BookDAO bookDao;
	
	public void addToCart(HttpSession session, int bid) throws Exception {
		List<CartItem> store = (List)session.getAttribute("cart");
		
		if(store==null){  //购物车不存在
			store = new ArrayList<CartItem>();  //第一次购物，创建购物车
		}else{	//购物车已存在，判断是否购买过
			for(CartItem item: store){
				if(item.getBook().getId()==bid){ //已购买过
					item.setQuantity(item.getQuantity()+1);  //数量加1
					session.setAttribute("cart", store);  //更新session
					return;
				}
			}
		}		
		//第一次购买
		//1.查询得到该图书信息
		Book book = bookDao.findById(bid);
		
		//2.创建购物项：数量为1
		CartItem item = new CartItem(book,1);		
		
		//3.加入购物车
		store.add(item);
		
		//4.更新session
		session.setAttribute("cart", store);
	}

	 /**
     * 获取购物车中所有商品的信息
     */
	public List<CartItem> getAllCartItems(HttpSession session) {	
		List<CartItem> store = (List)session.getAttribute("cart");
		if(store==null || store.size()==0){
			return null;   //使为空时的购物车页面一致，否则store存在，会显示空列表																																																																		
		}
		return store;
	}

	 /**
     * 修改购物数量
     */
	public void modifyCartItem(HttpSession session, int bid, int quantity) {
		List<CartItem> store = (List)session.getAttribute("cart");
		
		for(CartItem item:store){
			if(item.getBook().getId()==bid){
				item.setQuantity(quantity);
			}
		}
		session.setAttribute("cart", store);
	}
	
	
	/**
     * 删除商品
     */
	public void removeCartItem(HttpSession session, int bid) {
		List<CartItem> store = (List)session.getAttribute("cart");
		
		Iterator<CartItem> it = store.iterator();
		while(it.hasNext()){
			CartItem item = it.next();
			if(item.getBook().getId()==bid){
				it.remove();
				break;
			}
		}
		session.setAttribute("cart", store);
	}

	/**
     * 统计"确认购买"的商品的总价
     */
	public double getCartCost(HttpSession session) {
		List<CartItem> store = (List)session.getAttribute("cart");
		
		double total=0;
		if(store!=null){
			for(CartItem item:store){
				total+=item.getBook().getRealPrice()*item.getQuantity();
			}
		}
		return total;
	}
}
