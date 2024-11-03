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
		
		String code = request.getParameter("code");
		String sex = request.getParameter("sex");		
		String[] hobbies = request.getParameterValues("hobby");
		
		PrintWriter out = response.getWriter();
		out.print("用户名："+code+"<br/>");
		if(sex.equals("male")){
			out.print("性别：男<br/>");
		}else{
			out.print("性别：女<br/>");
		}				
		out.print("你订阅的内容包括:<br/>");		
		if(hobbies!=null){ 
			String h=null;
			for(String hobby: hobbies){
				switch(hobby){
					case "computer": h="计算机"; break;
					case "finance":  h="金融"; break;
					case "language": h="外语"; break;
				}
				out.print(h+"<br/>");		
			}
		}	
	}
}

