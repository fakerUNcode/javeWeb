<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ page import="bean.Student,bean.Course" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Insert title here</title>
</head>
<body>
	姓名：${stu.name }  <br>
	年级：${stu.grade } <br>
	选课1：${stu.courses[0].courseName }，学分：${stu.courses[0].creditHour } <br>
	选课2：${stu.courses[1].courseName }，学分：${stu.courses[1].creditHour } <br>
	
	<%=((Student)request.getAttribute("stu")).getName() %>
	<%=((Student)request.getAttribute("stu")).getCourses()[0].getCourseName() %>
	
	${stu['name'] }
</body>
</html>