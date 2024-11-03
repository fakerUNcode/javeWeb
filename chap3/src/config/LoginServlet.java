package config;

import java.io.IOException;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private int online = 0;  //在线人数计数器
	private int maxOnline;

	public void init(ServletConfig config)	throws ServletException {
		super.init(config);
		maxOnline = Integer.parseInt(config.getInitParameter("maxOnline"));
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		if(online<maxOnline){
			//准予登录，进入登录逻辑处理……
			System.out.println("登录成功.");
			online++;
		}else{
			//禁止登录处理……
			System.out.println("聊天室人数已满.");
		}
	}
}
