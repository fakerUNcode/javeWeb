package com.bookshopping.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookshopping.entity.Book;
import com.bookshopping.service.impl.AddBookService;

@Controller
public class AddBookController {
	
	@Resource(name="addbookService")
	private AddBookService service;
	
	@RequestMapping("/add.do")
	public void add(Book book){
		
		System.out.println(book);
		
		service.addBook(book);
	}
}
