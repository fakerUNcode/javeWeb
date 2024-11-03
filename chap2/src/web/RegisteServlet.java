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
		//��request��ȡ�������
		String code = request.getParameter("code");
		String sex = request.getParameter("sex");		
		String[] hobbies = request.getParameterValues("hobby");
//		request.getRequestDispatcher("/reg2").forward(request, response);
		
		//����response���������������
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("code: "+code+"<br/>");
		out.print("sex: "+sex+"<br/>");
		
		if(hobbies!=null){ //��ѡ�˶�������
			for(String hobby: hobbies){
				out.print("hobby: "+hobby+"<br/>");		
			}
		}	
		//response.sendRedirect("reg");
	}

}

