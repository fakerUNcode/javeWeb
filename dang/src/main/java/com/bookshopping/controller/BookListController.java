package com.bookshopping.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookshopping.entity.Book;
import com.bookshopping.entity.Category;
import com.bookshopping.service.BookService;
import com.bookshopping.service.CategoryService;

@Controller
@RequestMapping("/list")
public class BookListController {
	
	@Resource(name="bookService")
	private BookService bookService;
	
	@Resource(name="categoryService")
	private CategoryService categoryService;
	
	@RequestMapping("/cateAndBookList.do")
	public String findCateNumList(Map model, int pid, int cid, 
			@RequestParam(defaultValue="1")int page, 
			@RequestParam(defaultValue="3")int pageSize){
		//pid:一级分类
		//cid:二级分类
		try {
			//1.分类的名字
			String catName = categoryService.findNameById(pid);
			model.put("catName",catName);
			
			//2.pid下的二级分类
			List<Category> childList = categoryService.findByParentId(pid);
			model.put("childList", childList);
			
			//3.分类下的书的总数
			int totalNum=0;
			for(Category c: childList){
				totalNum += c.getBooks().size();
			}
			
			model.put("totalNum", totalNum);
			
			//4.分页总数
			int pages = bookService.findPageNumByCatId(cid, pageSize);
			model.put("totalPage", pages);
			
			//5.找到cid类别下的第page页图书列表，每页pageSize个书目
			List<Book> list = bookService.findPageBooksByCatId(cid, page, pageSize);
			model.put("books", list);
			
			model.put("page", page);
			model.put("pid", pid);
			model.put("cid",cid);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "booklist/book_list";
	}

}
