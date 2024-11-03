package cookie;

import java.io.IOException;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//获取参数
		String name = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
//		HttpSession session = request.getSession();
//		System.out.println(session.getId());
		if(name.equals("Lucy")&&pwd.equals("1234")){
			//一个cookie是一个键值对，必须是字符串
			Cookie c = new Cookie("userName", name);
//			Cookie c2 = new Cookie("loginTime", sdf.format(new Date()));
			
			//将cookie发送给浏览器，由浏览器保存
			response.addCookie(c); 
//			response.addCookie(c2);
			
			//重定向到主页
			response.sendRedirect("index.jsp");	
		}else{
			response.sendRedirect("login.html");	
		}
	}
}
