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
		
		//1.获取请求路径
		String path = request.getServletPath();
		
		if(path.equals("/find.do")){  
			//2.调用Model层的DAO完成业务性操作 
			StudentDao dao = new StudentDaoImpl();
			List<Student> list = dao.findAll();			
			
			//3.转发到jsp页面
			request.setAttribute("student",list);   //保存参数至request 			
			request.getRequestDispatcher("list.jsp").forward(request, response);  //3.2转发
		}else if(path.equals("/add.do")){//添加学生
			request.setCharacterEncoding("UTF-8");
			
			//1.收集表单数据，封装为Student对象
			String name = request.getParameter("name");
			String sex = request.getParameter("sex"); 
			if(sex.equals("female")){
				sex= "女";
			}else{
				sex="男";
			}
			
			//生日
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
			
			//2.调用dao持久化到数据库
			StudentDao dao = new StudentDaoImpl();
			dao.save(stu);
			
			//3.重定向到find.do
			response.sendRedirect("find.do");		
			
		}else if(path.equals("/toUpdate.do")){ 
			//1.查询学生
			StudentDao dao = new StudentDaoImpl();
			int id = Integer.parseInt(request.getParameter("id"));   //"1"->1
			Student stu = dao.findById(id);
			
			//2.将学生对象放在request中，准备传递
			request.setAttribute("stu",stu);
			
			//3.转发到update.jsp
			request.getRequestDispatcher("update.jsp").forward(request,response);
		}else if(path.equals("/update.do")){			
			request.setCharacterEncoding("UTF-8");
			//1.获取表单上的数据，封装为Student对象
			String name = request.getParameter("name");			
			String sex = request.getParameter("sex"); 
			if(sex.equals("female")){
				sex= "女";
			}else{
				sex="男";
			}
			//生日
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
			
			//2.获取参数id
			int id = Integer.parseInt(request.getParameter("id")); 
			stu.setId(id);
			
			//3.调用dao
			StudentDao dao = new StudentDaoImpl();
			dao.update(id, stu);
			
			//4.重定向到find.do			
			response.sendRedirect("find.do");  
		}else if(path.equals("/delete.do")){
			//1.获取id
			int id = Integer.parseInt(request.getParameter("id")); 
		
			//2.调用dao
			StudentDao dao = new StudentDaoImpl();
			Student stu = dao.findById(id);
			dao.delete(id);
			
			//3.重定向到find.do
			//当前路径：8080/stu/delete.do
			//目标路径：8080/stu/find.do			
			response.sendRedirect("find.do");  
		}	
	}
}
