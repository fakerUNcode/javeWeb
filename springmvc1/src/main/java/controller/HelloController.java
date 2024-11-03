package controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 处理器类。
 *  1. 实现Controller接口。
 *  2. 将业务逻辑写在handleRequest方法里面。
 */
public class HelloController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		System.out.println(	"HelloController's handleRequest()");
		/*
		 * ModelAndView有两个构造器：
		 * ModelAndView(String viewName):viewName是视图名
		 * ModelAndView(String viewName, Map data):data是处理结果
		 */
		return new ModelAndView("hello");
		
	}
}



