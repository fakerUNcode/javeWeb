package context;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CountDemoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context =super.getServletContext(); 
		HttpSession session = request.getSession();
		Object count = context.getAttribute("count");
		if(count==null){
			context.setAttribute("count", 0);
		}
		
		int c = Integer.parseInt(context.getAttribute("count").toString());
		context.setAttribute("count",c+1);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(context.getAttribute("count"));
	}
}
