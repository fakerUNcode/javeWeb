package controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import bean.Product;

/**
 * 处理器类。
 *  1. 实现Controller接口。
 *  2. 将业务逻辑写在handleRequest方法里面。
 */
public class AddProductController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		Product product = new Product();
		product.setName(request.getParameter("name"));
		product.setDesc(request.getParameter("describe"));
		product.setPrice(Double.parseDouble(request.getParameter("price")));
		
		request.setAttribute("product", product);
		
		return new ModelAndView("show");
		
	}
}



