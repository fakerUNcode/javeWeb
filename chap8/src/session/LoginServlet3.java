package session;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet3  extends HttpServlet {
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
//		String name = request.getParameter("username");
//		String pwd = request.getParameter("pwd");
		
//		if(name.equals("Lucy")&&pwd.equals("1234")){
			//按照sessionID查找到session对象返回
			HttpSession session  = request.getSession();	
//			session.invalidate();
//			session.setAttribute("userName", name);	
			//重定向时继续重写URL，携带sessionID
//			response.sendRedirect(response.encodeRedirectURL("session/index.jsp"));
//		}else{
//			response.sendRedirect("http://localhost:8080/chap2/registe.html");
//			response.sendRedirect(response.encodeRedirectURL("http://localhost:8080/chap2/registe.html"));
			response.sendRedirect(response.encodeRedirectURL("index.jsp"));
//		}
	}
		
}
