<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ page import="bean.Student,bean.Course" %>
<%@ page import="java.util.ArrayList,java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>forEach标签</title>
</head>
<body>
	<%
		List<Student> list = new ArrayList<Student>();
	
		Course[] c = new Course[2];
		c[0] = new Course("Web程序设计",4);
		c[1] = new Course("数据结构",4);
		
		Student stu1 = new Student();
		stu1.setName("Lucy");
		stu1.setGrade(2);
		stu1.setCourses(c);
		list.add(stu1);
		
		Student stu2 = new Student();
		stu2.setName("Leo");
		stu2.setGrade(1);
		c = new Course[2];
		c[0] = new Course("Java程序设计",4);
		c[1] = new Course("大学计算机",2);
		stu2.setCourses(c);
		
		list.add(stu2);
		request.setAttribute("list",list);
	%>
	<c:forEach items="${list}" var="stu" varStatus="s1">
		${s1.count} &nbsp; &nbsp;
		${stu.name} &nbsp; &nbsp;
		${stu.grade}年级 <br>
		<c:forEach items="${stu.courses}" var="c" varStatus="s2">
			&nbsp; &nbsp;${s2.index} 
			&nbsp; &nbsp;${c.courseName }
			&nbsp; &nbsp;${c.creditHour }
			<br>
		</c:forEach>
		<br>
	</c:forEach>
</body>
</html>