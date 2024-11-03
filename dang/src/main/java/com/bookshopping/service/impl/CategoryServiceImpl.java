package com.bookshopping.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bookshopping.dao.CategoryDAO;
import com.bookshopping.entity.Category;
import com.bookshopping.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{
	
	@Resource(name = "categoryDAO")
	private CategoryDAO dao;
	
	public List<Category> getAllCategory(){
		try {
			return dao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public String findNameById(int id) throws SQLException {
		return dao.findNameById(id);
	}


	public List<Category> findByParentId(int pid) throws SQLException {
		return dao.findByParentId(pid);
	}
	
	

}
