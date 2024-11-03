package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet2  extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		if(name.equals("Lucy")&&pwd.equals("1234")){
			HttpSession session  = request.getSession();			
			//设置session的生命周期为10分钟
			session.setMaxInactiveInterval(10);
			session.setAttribute("userName", name);			
			//response.sendRedirect("session/index.jsp");
		}else{
			response.sendRedirect("login.html");
		}
	}
		
}
