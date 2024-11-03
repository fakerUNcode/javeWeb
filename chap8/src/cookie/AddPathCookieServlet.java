package cookie;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddPathCookieServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Cookie c1 = new Cookie("c1","Tom");   //默认路径
		Cookie c2 = new Cookie("c2","Jerry");   
		Cookie c3 = new Cookie("c3","Nemo");  
		Cookie c4 = new Cookie("c4","Dory"); 

		c2.setPath(request.getContextPath()+"/path1");  
		c3.setPath(request.getContextPath()+"/path1");
		c4.setPath(request.getContextPath()+"/path2");
		
		//将cookie发送给浏览器，由浏览器保存
		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);
		response.addCookie(c4);
	}


}
