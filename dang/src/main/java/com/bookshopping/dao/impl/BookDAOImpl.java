package com.bookshopping.dao.impl;

import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bookshopping.dao.BookDAO;
import com.bookshopping.entity.Book;


@Repository("bookDAO")  
public class BookDAOImpl implements BookDAO{

	@Resource(name="jdbcTemplate")
	private JdbcTemplate template;
	
	/***
	 * 查询新书热卖
	 * size：数量
	 * 返回值：推荐书list
	 */
	public List<Book> findHotNewBook(Date add_time, int size) throws SQLException {
		String sql ="select sum(book_num) as num, b.* from item i join book b "
				+ "on b.id= i.book_id  where publish_time>? group by book_id order by num desc limit 0,?";
		
		Object[] params = new Object[]{add_time, size};
		
		return template.query(sql, params ,new BookRowMapper());
	}

	private class BookRowMapper implements RowMapper<Book>{
		public Book mapRow(ResultSet rs, int index) 
				throws SQLException {
			Book book = new Book();  			
			//book表字段
			book.setId(rs.getInt("id"));
			book.setBookName(rs.getString("book_name"));
			book.setAuthor(rs.getString("author"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublishTime(rs.getLong("publish_time"));
			book.setWhichEdtion(rs.getString("which_edtion"));
			book.setTotalPage(rs.getString("total_page"));
			book.setIsbn(rs.getString("isbn"));
			book.setAuthorSummary(rs.getString("author_summary"));
			book.setCatalogue(rs.getString("catalogue"));
			book.setDescription(rs.getString("description"));
			book.setFixedPrice(rs.getDouble("fixed_price"));
			book.setRealPrice(rs.getDouble("real_price"));
			book.setPicture(rs.getString("picture"));
			
			return book;
		}
	}

	/***
	 * 查询推荐图书
	 * size：数量
	 * 算法：按商品id查询订单项表中的销售数量，并排序，在前10条记录中随机指定size条
	 * 返回值：推荐书list
	 */
	public List<Book> findRecommendBook(final int size) throws SQLException{
		String sql = "select  * from ("
				+ "select sum(book_num) as num,b.* from item i join book b on b.id= i.book_id "
				+ "group by book_id order by  num desc limit 0,10)  as a "
				+ "order by rand() limit 0,?";

		Object[] params = new Object[]{size};
		
		return template.query(sql, params ,new BookRowMapper());
	}
	
	/***
	 * 按分类id查询该类别的图书
	 * cid：分类号
	 * 算法：对book表，category_book表连接查找，获取某分类下的图书集合
	 * 返回值：list
	 */
	public List<Book> findBooksByCatId(final int cid)  throws SQLException{
		
		String sql = "select b.* from book b join category_book cb "
				+ "on b.id=cb.book_id where cb.cat_id=?";

		Object[] params = new Object[]{cid};
		
		return template.query(sql, params ,new BookRowMapper());
	}

	/***
	 * 功能：找到每个分类下的图书的数量，并计算好分页
	 * 
	 */
	public int findPageNumByCatId(final int catId,int pageSize)throws SQLException {
		int totalRows = findBooksByCatId(catId).size(); 
		//计算总页数
		//根据totalRows和pageSize计算总页数totalPages
		if(totalRows == 0){
			return 1;	//没有记录认为1页
		}else if(totalRows%pageSize == 0){
			return totalRows/pageSize;
		}else{
			return totalRows/pageSize+1;
		}
	}
	
	
	/***
	 * 按分类id查询该类别的图书
	 * cid：分类号
	 * page: 页号
	 * pageSize: 每页大小
	 * 算法：对book表，category_book表连接查找，获取某分类下的图书集合
	 * 返回值：list
	 */
	public List<Book> findPageBooksByCatId(final int cid, final int page, 
			final int pageSize) throws SQLException{
		
		String sql = "select b.* from book b join category_book cb on (b.id=cb.book_id) "
				+ "where cb.cat_id=? limit ?,?";

		Object[] params = new Object[]{cid,(page-1)*pageSize, pageSize};
		
		return template.query(sql, params ,new BookRowMapper());
		
	}

	public Book findById(int id) throws SQLException {		
		String sql = "select * from book where id= ?";
		Object[] params = new Object[]{id};
		try{
			return template.queryForObject(sql, params ,new BookRowMapper());
		}catch(Exception e){
			return null;
		}
	}

}
