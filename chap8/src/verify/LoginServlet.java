package verify;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		// 校验验证码
		String code = (String) session.getAttribute("verifyCode");
		String vcode = request.getParameter("vcode");

		// 获取参数
		String userName = request.getParameter("username");
		String pwd = request.getParameter("pwd");

		if ("Lucy".equals(userName) && "1234".equals(pwd) 
				&& code.equalsIgnoreCase(vcode)) {			
			session.setAttribute("userName", userName);
			response.sendRedirect("verify/index.jsp");
		} else {
			response.sendRedirect(request.getContextPath() +"/verify/login.html");
		}
	}
}
