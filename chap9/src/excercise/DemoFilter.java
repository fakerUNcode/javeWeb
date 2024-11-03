package excercise;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoFilter implements Filter {
	public void doFilter(ServletRequest req, ServletResponse res, 
			FilterChain chain)	throws IOException, ServletException {		
		System.out.print("1");
		chain.doFilter(req, res);
		System.out.print("2");
	}

	public void init(FilterConfig config) throws ServletException {
	}
	
	public void destroy() {

	}

}
