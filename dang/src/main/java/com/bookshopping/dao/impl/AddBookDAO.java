package com.bookshopping.dao.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bookshopping.entity.Book;

@Repository("addbookDAO")  
public class AddBookDAO {
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate template;
	
	public void save(Book book) {
		//1.
		String sql = "insert into book values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		//2.
		Object[] params = new Object[]{
				book.getBookName(),
				book.getAuthor(),
				book.getPublishing(),
				book.getPublishTime(),
				book.getWhichEdtion(),
				book.getTotalPage(),
				book.getPrintTime(),
				book.getIsbn(),
				book.getAuthorSummary(),
				book.getCatalogue(),
				book.getDescription(),
				book.getFixedPrice(),
				book.getRealPrice(),
				book.getPicture()
		};
		
		//3.
		template.update(sql,params);
	}

}
