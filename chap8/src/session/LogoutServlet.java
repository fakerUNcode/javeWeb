package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {
	protected void service(HttpServletRequest request, 
			HttpServletResponse response)  throws ServletException, IOException {
		//��ʽ1
//		request.getSession().removeAttribute("userName");
		
		//��ʽ2
		//request.getSession().invalidate();
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
}
