<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ page import="bean.Student,bean.Course" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Insert title here</title>
</head>
<body>
<%
	Course[] c = new Course[2];
	c[0] = new Course("Java Web",4);
	c[1] = new Course("MySQL",3);
	
	Student stu = new Student();
	stu.setName("Lucy");
	stu.setGrade(2);
	stu.setCourses(c);
	request.setAttribute("stu", stu);    //´æÈërequest¶ÔÏó
	request.getRequestDispatcher("get.jsp").forward(request,response); 
%>
</body>
</html>