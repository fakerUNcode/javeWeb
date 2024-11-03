package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CircleDemoFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("过滤器被销毁");
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("chain.doFilter()调用前，可以对请求进行预处理...");
		chain.doFilter(req, res);
		System.out.println("chain.doFilter()调用后，可以对响应进行处理...");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("过滤器初始化");		
	}

}
