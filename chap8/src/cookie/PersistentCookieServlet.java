package cookie;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersistentCookieServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
        //����Cookie
        Cookie c1 = new Cookie("c1","Lucy");
       
        System.out.println(c1.getPath());
        //����c1�Ĺ���ʱ��
        c1.setMaxAge(60*60);
        response.addCookie(c1);
        System.out.println("c1���������ڣ�"+c1.getMaxAge()+"��");
        
        Cookie c2 = new Cookie("c2","Leo");
        response.addCookie(c2);
        System.out.println("c2���������ڣ�"+c2.getMaxAge()+"��");
	}

}
