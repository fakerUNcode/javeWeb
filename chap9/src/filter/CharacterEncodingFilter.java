package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CharacterEncodingFilter implements Filter {
	private String encoding;

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		req.setCharacterEncoding(encoding);  //post方式有效
		//指定默认响应方式，web组件可以自行修改
		//防止缓存后不知道如何解读字节流
		res.setContentType("text/html;charset="+encoding);
		HttpServletRequest request = (HttpServletRequest)req;
		MyCharacterEncodingRequest requestWrapper = new MyCharacterEncodingRequest(request);
		chain.doFilter(requestWrapper, res);
	}

	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
	}
	
	public void destroy() {

	}

}

class MyCharacterEncodingRequest extends HttpServletRequestWrapper {
	//构造方法：初始化被增强对象
	public MyCharacterEncodingRequest(HttpServletRequest request) {
		super(request);
	}

	//覆盖需要增强的getParameter()方法
	public String getParameter(String name) {
		try {
			String value = super.getParameter(name);
			if (value == null) {
				return null;
			}
			//如果不是以get方式提交，直接返回参数的取值
			if (!super.getMethod().equalsIgnoreCase("get")) {
				return value;
			} else { //如果是以get方式提交，对获参数取值进行转码处理
				//1.获取编码方式：过滤器中req.setCharacterEncoding(encoding)的设置
				String encoding = super.getCharacterEncoding();
				//getBytes()的参数为Tomcat的默认编码
				value = new String(value.getBytes("ISO8859-1"), encoding);
				return value;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
