package com.bookshopping.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bookshopping.dao.impl.AddBookDAO;
import com.bookshopping.entity.Book;

@Service("addbookService")
public class AddBookService {
	
	@Resource(name = "addbookDAO")
	private AddBookDAO dao;
	
	public void addBook(Book book) {
			dao.save(book);
	}
}

