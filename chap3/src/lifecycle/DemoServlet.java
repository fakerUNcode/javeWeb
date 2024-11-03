package lifecycle;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet {
	public DemoServlet() {
		super();
		System.out.println("创建DemoServlet");
	}
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response)  
			throws ServletException, IOException {		
		System.out.println("DemoServlet service方法被调用");
	}
	@Override
	public void destroy() {		
		super.destroy();
		System.out.println("DemoServlet销毁");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("DemoServlet初始化");
	}
}
