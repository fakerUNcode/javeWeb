package com.bookshopping.dao;

import java.sql.SQLException;

import java.util.List;

import com.bookshopping.entity.Category;


public interface CategoryDAO {
	public List<Category> findByParentId(int id) throws SQLException;	
	public List<Category> findAll() throws SQLException;	
	public String findNameById(int id) throws SQLException;
}
