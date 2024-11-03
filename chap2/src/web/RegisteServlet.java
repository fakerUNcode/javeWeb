package web;
import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisteServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		//从request读取请求参数
		String code = request.getParameter("code");
		String sex = request.getParameter("sex");		
		String[] hobbies = request.getParameterValues("hobby");
//		request.getRequestDispatcher("/reg2").forward(request, response);
		
		//利用response向浏览器返回数据
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("code: "+code+"<br/>");
		out.print("sex: "+sex+"<br/>");
		
		if(hobbies!=null){ //勾选了订阅数据
			for(String hobby: hobbies){
				out.print("hobby: "+hobby+"<br/>");		
			}
		}	
		//response.sendRedirect("reg");
	}

}

