package web;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.impl.StudentDaoImpl;
import dao.StudentDao;
import entity.Student;

public class MainServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		//1.��ȡ����·��
		String path = request.getServletPath();
		
		ServletContext application = super.getServletContext();
		int pageSize = Integer.parseInt(application.getInitParameter("size"));
		
		if(path.equals("/find.do")){  
			int page;
			String page_str = request.getParameter("page");
			if(page_str==null){
				page = 1;
			}else{
				page = Integer.parseInt(page_str);
			}
			
			StudentDao dao = new StudentDaoImpl();
			List<Student> list = dao.findAll();
			int n = list.size();
			int totalPage;
			if(n<pageSize){
				totalPage=1;
			}else if(n%pageSize==0){
				totalPage = n/pageSize;
			}else{
				totalPage = n/pageSize+1;
			}
			System.out.println(totalPage);
			
			request.setAttribute("currentPage", page);
			request.setAttribute("totalPage", totalPage);
			list = dao.findByPage(page,pageSize);
			
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
		}else if(path.equals("/findAll.do")){
			int page;
			String page_str = request.getParameter("page");
			if(page_str==null){
				page = 1;
			}else{
				page = Integer.parseInt(page_str);
			}
			
			StudentDao dao = new StudentDaoImpl();
			
			//1.��ȡid
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String mobilephone = request.getParameter("mobilephone");
			String sex = request.getParameter("sex");
			System.out.println(id+","+name+","+mobilephone+","+sex);
			
			dao = new StudentDaoImpl();
			List<Student> list = dao.findByMultiCondition(id, name, mobilephone, sex);
			int n = list.size();
			int totalPage;
			if(n<pageSize){
				totalPage=1;
			}else if(n%pageSize==0){
				totalPage = n/pageSize;
			}else{
				totalPage = n/pageSize+1;
			}
			
			System.out.println(totalPage);
		
			List<Student> returnList = new ArrayList<Student>(); 
			for(int i=(page-1)*pageSize; i<list.size() && i<page*pageSize; i++){
				returnList.add(list.get(i));
			}
			request.setAttribute("student", returnList);

			request.setAttribute("currentPage", page);
			request.setAttribute("totalPage", totalPage);
			
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}
	}
}
