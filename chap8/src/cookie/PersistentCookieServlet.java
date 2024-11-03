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
		
        //创建Cookie
        Cookie c1 = new Cookie("c1","Lucy");
       
        System.out.println(c1.getPath());
        //设置c1的过期时间
        c1.setMaxAge(60*60);
        response.addCookie(c1);
        System.out.println("c1的生命周期："+c1.getMaxAge()+"秒");
        
        Cookie c2 = new Cookie("c2","Leo");
        response.addCookie(c2);
        System.out.println("c2的生命周期："+c2.getMaxAge()+"秒");
	}

}
