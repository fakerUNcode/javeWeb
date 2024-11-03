package com.bookshopping.service;

import java.sql.SQLException;
import java.util.List;

import com.bookshopping.entity.Category;

public interface CategoryService {
	
	public String findNameById(int id) throws SQLException;
	public List<Category> findByParentId(int pid) throws SQLException;
	public List<Category> getAllCategory();

}
