package com.bookshopping.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookshopping.entity.Result;
import com.bookshopping.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Resource(name="cartService")
	private CartService service;
	
	@RequestMapping("/addcart.do")
	@ResponseBody
	public Result addToCart(HttpSession session, int bid){
		Result r = new Result();
		try {
			service.addToCart(session, bid);
			r.setStatus(1);
			r.setMsg("购买成功");
		} catch (Exception e) {
			r.setStatus(0);
			r.setMsg("购买失败");
		}
		return r;
	}
	
	@RequestMapping("/cartlist.do")
	public String getCartList(HttpSession session, Map model){
		model.put("cartlist", service.getAllCartItems(session));
		
		model.put("total", service.getCartCost(session));
		
		return "cart/cartlist"; 
	}
	
	@RequestMapping("/modifycart.do")
	public String modifyCart(HttpSession session, int bid, int quantity){
		service.modifyCartItem(session, bid, quantity);
		
		return "redirect:cartlist.do"; 
	}
	
	@RequestMapping("/deletecart.do")
	public String removeCartItem(HttpSession session, int bid){
		service.removeCartItem(session, bid);
		
		return "redirect:cartlist.do"; 
	}
}
