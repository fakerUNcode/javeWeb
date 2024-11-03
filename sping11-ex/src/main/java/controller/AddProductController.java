package controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import bean.Product;

/**
 * �������ࡣ
 *  1. ʵ��Controller�ӿڡ�
 *  2. ��ҵ���߼�д��handleRequest�������档
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



