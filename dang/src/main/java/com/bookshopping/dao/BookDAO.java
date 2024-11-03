package com.bookshopping.dao;

import java.sql.Date;

import java.sql.SQLException;
import java.util.List;

import com.bookshopping.entity.Book;

public interface BookDAO {
	
	public List<Book> findRecommendBook(int size) throws SQLException;	
	public List<Book> findHotNewBook(Date add_time, int size) throws SQLException;		
	public List<Book> findBooksByCatId(int cid) throws SQLException;
	
	//BookList使用
	public int findPageNumByCatId(int cat_id,int pageSize) throws SQLException;		
	public List<Book> findPageBooksByCatId(int cid, int page, int pageSize) throws SQLException;
	
	//CartDAO使用
	public Book findById(int id) throws SQLException;  

}
