package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {	
	
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();		
		pw.print("hello world");
	}	
}

