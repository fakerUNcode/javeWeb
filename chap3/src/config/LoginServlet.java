package config;

import java.io.IOException;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private int online = 0;  //��������������
	private int maxOnline;

	public void init(ServletConfig config)	throws ServletException {
		super.init(config);
		maxOnline = Integer.parseInt(config.getInitParameter("maxOnline"));
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		if(online<maxOnline){
			//׼���¼�������¼�߼�������
			System.out.println("��¼�ɹ�.");
			online++;
		}else{
			//��ֹ��¼������
			System.out.println("��������������.");
		}
	}
}
