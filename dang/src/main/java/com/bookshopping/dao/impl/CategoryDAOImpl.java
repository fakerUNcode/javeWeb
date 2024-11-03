package com.bookshopping.dao.impl;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bookshopping.dao.BookDAO;
import com.bookshopping.dao.CategoryDAO;
import com.bookshopping.entity.Book;
import com.bookshopping.entity.Category;

@Repository("categoryDAO")  
public class CategoryDAOImpl implements CategoryDAO {
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate template;
	
	@Resource(name="bookDAO")
	private BookDAO bookDao;
	
	/***
	 * 按id找到分类的名字
	 */	
	public String findNameById(int id) throws SQLException{
		String sql = "select * from category where id=?";
		
		Object[] params = new Object[]{id};
		
		Category c = template.queryForObject(sql, params, new CategoryRowMapper());
		return c.getName();
	}
	
	private class CategoryRowMapper implements RowMapper<Category>{
		public Category mapRow(ResultSet rs, int index) 
				throws SQLException {
			Category c = new Category();
			c.setId(rs.getInt("id"));
			c.setName(rs.getString("name"));
			c.setDescription(rs.getString("description"));
			c.setParentId(rs.getInt("parent_id"));
			
			return c;
		}
	}
	
	/***
	 * 按照parent_id查询目录项
	 * 返回值：目录项集合
	 */
	private List<Category> findByParentIdInner(int pid) throws SQLException {
		String sql = "select * from category where parent_id=?";
		
		Object[] params = new Object[]{pid};
		
		return template.query(sql, params ,new CategoryRowMapper());
	}

	/***
	 * 功能：获取所有一级目录及其对应的二级目录
	 * 算法：取到category中的所有一级目录(parent_id=0)：list
	 *       按一级目录id找到其下的所有二级目录：childrenList
	 * 返回值：list
	 */
	public List<Category> findAll() throws SQLException {
		List<Category> list = new ArrayList<Category>();
		list = findByParentIdInner(0);
		Iterator<Category> it = list.iterator();
		while(it.hasNext()){
			Category c= (Category)it.next();
			int pid = c.getId(); //一级目录的id
			List<Category> childrenList = new ArrayList<Category>();
			childrenList = findByParentIdInner(pid);  //该一级目录的子目录
			c.setChildrenListCates(childrenList);	
			
			//booklist所用功能,二级分类下书目及数量
			Iterator<Category> itChild = childrenList.iterator();
			while(itChild.hasNext()){
				//二级目录
				Category c2= (Category)itChild.next();
				List<Book> bookList = bookDao.findBooksByCatId(c2.getId());
				c2.setBooks(bookList);
			}
		}
		return list;
	}

	public List<Category> findByParentId(int pid) throws SQLException {
		List<Category> list = findAll();
		Iterator<Category> it = list.iterator();
		while(it.hasNext()){
			Category c= (Category)it.next();
			int id = c.getId(); //一级目录的id
			if(id==pid){
				return c.getChildrenListCates();
			}
		}
		return null;
	}
	
}
