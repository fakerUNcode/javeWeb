package web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisteServlet2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		//��request��ȡ�������
		String code = request.getParameter("code");
		String sex = request.getParameter("sex");		
		String[] hobbies = request.getParameterValues("hobby");
		
		//����response���������������
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("���: "+code+"<br/>");
		if(sex.equals("male")){
			out.print("�Ա�: ��<br/>");
		}else{
			out.print("�Ա�: Ů<br/>");
		}				
		out.print("�㶩�ĵ����ݰ���:<br/>");		
		if(hobbies!=null){ //��ѡ�˶�������
			String h=null;
			for(String hobby: hobbies){
				switch(hobby){
					case "computer": h="�����"; break;
					case "finance":  h="����"; break;
					case "language": h="����"; break;
				}
				out.print(h+"<br/>");		
			}
		}	
	}
}

