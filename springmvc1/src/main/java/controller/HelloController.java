package controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * �������ࡣ
 *  1. ʵ��Controller�ӿڡ�
 *  2. ��ҵ���߼�д��handleRequest�������档
 */
public class HelloController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		System.out.println(	"HelloController's handleRequest()");
		/*
		 * ModelAndView��������������
		 * ModelAndView(String viewName):viewName����ͼ��
		 * ModelAndView(String viewName, Map data):data�Ǵ�����
		 */
		return new ModelAndView("hello");
		
	}
}



