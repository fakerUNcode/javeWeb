package excercise;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageFilter implements Filter {
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String referer = request.getHeader("referer");  //自己的链接地址
		
//		System.out.println(referer);
//		System.out.println(request.getServerName());
		
		String serverName = request.getServerName();  //请求所在服务器
		if(referer!=null && !referer.contains(serverName)){
			System.out.println("禁止访问");
			request.getRequestDispatcher("error.html").forward(request, response);
			return;
		}
		chain.doFilter(req, res);
	}

	public void init(FilterConfig config) throws ServletException {
	}

	public void destroy() {

	}

}
