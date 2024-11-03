package com.bookshopping.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookshopping.entity.Book;
import com.bookshopping.service.BookService;

@Controller
@RequestMapping("/main")
public class BookController {
	
	@Resource(name="bookService")
	private BookService service;
	
	@RequestMapping("/recommend.do")
	public String findHotBook(Map model, int size){
		
		List<Book> list = service.findRecommendBook(size);
		model.put("hotList", list);
		return "main/recommend";
	}
	
	
	@RequestMapping("/hot.do")
	public String findHotNewBook(Map model, int size){
		
		List<Book> list = service.findHotNewBook(new java.sql.Date(new Date().getTime()), size);
		model.put("hotNewList", list);
		return "main/hotTop";
	}
	
	
}
