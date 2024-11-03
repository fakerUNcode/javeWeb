package com.bookshopping.service;

import java.util.Date;
import java.util.List;

import com.bookshopping.entity.Book;

public interface BookService {
	
	public List<Book> findHotNewBook(Date add_time, int size);  
	
	public List<Book> findRecommendBook(int size);
	
	public List<Book> findBooksByCatId(int cid);
	
	public int findPageNumByCatId(final int catId,int pageSize);
	
	public List<Book> findPageBooksByCatId(int cid, int page, int pageSize);

}
