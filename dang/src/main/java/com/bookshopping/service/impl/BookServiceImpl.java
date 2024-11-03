package com.bookshopping.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bookshopping.dao.BookDAO;
import com.bookshopping.entity.Book;
import com.bookshopping.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService{

	@Resource(name = "bookDAO")
	private BookDAO dao;
	
	public List<Book> findHotNewBook(Date publish_time, int size) {
		try {
			return dao.findHotNewBook(new java.sql.Date(publish_time.getTime()), size);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Book> findRecommendBook(int size){
		try {
			return dao.findRecommendBook(size);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Book> findBooksByCatId(int cid) {
		try {
			return dao.findBooksByCatId(cid);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int findPageNumByCatId(int catId, int pageSize) {
		try {
			return dao.findPageNumByCatId(catId, pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public List<Book> findPageBooksByCatId(int cid, int page, int pageSize) {
		try {
			return dao.findPageBooksByCatId(cid, page, pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
