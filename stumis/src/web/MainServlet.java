package web;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.StudentDaoImpl;
import dao.StudentDao;
import entity.Student;

public class MainServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		//1.��ȡ����·��
		String path = request.getServletPath();
		
		if(path.equals("/find.do")){  
			//2.����Model���DAO���ҵ���Բ��� 
			StudentDao dao = new StudentDaoImpl();
			List<Student> list = dao.findAll();			
			
			//3.ת����jspҳ��
			request.setAttribute("student",list);   //���������request 			
			request.getRequestDispatcher("list.jsp").forward(request, response);  //3.2ת��
		}else if(path.equals("/add.do")){//���ѧ��
			request.setCharacterEncoding("UTF-8");
			
			//1.�ռ������ݣ���װΪStudent����
			String name = request.getParameter("name");
			String sex = request.getParameter("sex"); 
			if(sex.equals("female")){
				sex= "Ů";
			}else{
				sex="��";
			}
			
			//����
			String bir = request.getParameter("birthday"); 
			//String->java.util.Date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date birthday =null;
			try {
				birthday = sdf.parse(bir);
			} catch (ParseException e) {				
				e.printStackTrace();
			}
			
			String mobilephone = request.getParameter("mobilephone");
			String email = request.getParameter("email");
			Student stu = new Student(name,sex,birthday,mobilephone,email);
			
			//2.����dao�־û������ݿ�
			StudentDao dao = new StudentDaoImpl();
			dao.save(stu);
			
			//3.�ض���find.do
			response.sendRedirect("find.do");		
			
		}else if(path.equals("/toUpdate.do")){ 
			//1.��ѯѧ��
			StudentDao dao = new StudentDaoImpl();
			int id = Integer.parseInt(request.getParameter("id"));   //"1"->1
			Student stu = dao.findById(id);
			
			//2.��ѧ���������request�У�׼������
			request.setAttribute("stu",stu);
			
			//3.ת����update.jsp
			request.getRequestDispatcher("update.jsp").forward(request,response);
		}else if(path.equals("/update.do")){			
			request.setCharacterEncoding("UTF-8");
			//1.��ȡ���ϵ����ݣ���װΪStudent����
			String name = request.getParameter("name");			
			String sex = request.getParameter("sex"); 
			if(sex.equals("female")){
				sex= "Ů";
			}else{
				sex="��";
			}
			//����
			String bir = request.getParameter("birthday");  
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date birthday =null;
			try {
				birthday = sdf.parse(bir);
			} catch (ParseException e) {				
				e.printStackTrace();
			}
			String mobilephone = request.getParameter("mobilephone");
			String email = request.getParameter("email");			
			Student stu = new Student(name,sex,birthday,mobilephone,email);
			
			//2.��ȡ����id
			int id = Integer.parseInt(request.getParameter("id")); 
			stu.setId(id);
			
			//3.����dao
			StudentDao dao = new StudentDaoImpl();
			dao.update(id, stu);
			
			//4.�ض���find.do			
			response.sendRedirect("find.do");  
		}else if(path.equals("/delete.do")){
			//1.��ȡid
			int id = Integer.parseInt(request.getParameter("id")); 
		
			//2.����dao
			StudentDao dao = new StudentDaoImpl();
			Student stu = dao.findById(id);
			dao.delete(id);
			
			//3.�ض���find.do
			//��ǰ·����8080/stu/delete.do
			//Ŀ��·����8080/stu/find.do			
			response.sendRedirect("find.do");  
		}	
	}
}
