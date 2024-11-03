package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet  extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		System.out.println(name);
		if(name.equals("嘻嘻")&&pwd.equals("1234")){
			HttpSession session  = request.getSession();
			
			session.setAttribute("user", name);
			
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else{
			response.sendRedirect(request.getContextPath()+"/login.html");
		}
	}
		
}
