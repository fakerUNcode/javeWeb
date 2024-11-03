package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServletJS  extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String url = request.getParameter("url");
		
		if(name.equals("Lucy") && pwd.equals("1234")){
			//1.获取session对象
			HttpSession session  = request.getSession();
			
			//2.在session中存放登录信息
			session.setAttribute("userName", name);
			
			//3.响应时，服务器会自动给浏览器传sessionID
			//4.重定向到主页
//			response.sendRedirect("session/index.jsp");
			response.sendRedirect(url);
		}else{
			response.sendRedirect("login.html");
		}
	}
		
}
