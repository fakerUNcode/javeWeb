package com.bookshopping.controller;

import java.util.Map;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookshopping.service.CategoryService;

@Controller
@RequestMapping("/main")
public class CategoryController {
	
	@Resource(name="categoryService")
	private CategoryService service;
	
	@RequestMapping("/getCategory.do")
	public String getCategory(Map model){
		
		model.put("cats", service.getAllCategory());
		
		return "main/category";
	}
	
}
