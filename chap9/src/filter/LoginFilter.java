package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("user");
		if(username==null){
			response.sendRedirect(request.getContextPath()+"/login.html");
			return;
		}				
		chain.doFilter(request, res);
	}

	public void init(FilterConfig config) throws ServletException {
	}
	
	public void destroy() {
	}

}
