package web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CommentServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("data");
		
		PrintWriter out = response.getWriter();
		out.print("评论："+code+"<br/>");
	}
}

