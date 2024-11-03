package context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindBookListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		// 获取ServletContext对象
		ServletContext context = super.getServletContext();
		System.out.println(context.getInitParameter("size"));
	}
}
