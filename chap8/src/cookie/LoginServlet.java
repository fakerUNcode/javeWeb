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
		//��ȡ����
		String name = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
//		HttpSession session = request.getSession();
//		System.out.println(session.getId());
		if(name.equals("Lucy")&&pwd.equals("1234")){
			//һ��cookie��һ����ֵ�ԣ��������ַ���
			Cookie c = new Cookie("userName", name);
//			Cookie c2 = new Cookie("loginTime", sdf.format(new Date()));
			
			//��cookie���͸�������������������
			response.addCookie(c); 
//			response.addCookie(c2);
			
			//�ض�����ҳ
			response.sendRedirect("index.jsp");	
		}else{
			response.sendRedirect("login.html");	
		}
	}
}
