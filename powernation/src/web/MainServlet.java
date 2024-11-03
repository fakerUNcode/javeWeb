package web;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.NewsDaoImpl;
import dao.NewsDao;
import entity.News;

public class MainServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		//1.��ȡ����·��
		String path = request.getServletPath();
		
		if(path.equals("/find.do")){  
			//2.����Model���DAO���ҵ���Բ��� 
			NewsDao dao = new NewsDaoImpl();
			List<News> list = dao.findAll();			
			
			//3.ת����jspҳ��
			request.setAttribute("news",list);   //���������request 			
			request.getRequestDispatcher("power/news.jsp").forward(request, response);  //3.2ת��
		}
	}
}
