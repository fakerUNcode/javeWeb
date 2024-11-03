package cookie;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodeServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// 
		String city = URLEncoder.encode("北京","UTF-8");
//		String code = URLEncoder.encode("北京", "UTF-8");
//		System.out.println(URLDecoder.decode(code, "UTF-8"));
		Cookie c = new Cookie("city",city);
		response.addCookie(c);
	}
}
