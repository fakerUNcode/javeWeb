package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{
	private String encoding;
	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.print("doFilter");
		req.setCharacterEncoding(encoding);
		res.setCharacterEncoding(encoding);

		chain.doFilter(req, res);
	}

	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
	}

}
