<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ page import="bean.Student,bean.Course" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Insert title here</title>
</head>
<body>
	������${stu.name }  <br>
	�꼶��${stu.grade } <br>
	ѡ��1��${stu.courses[0].courseName }��ѧ�֣�${stu.courses[0].creditHour } <br>
	ѡ��2��${stu.courses[1].courseName }��ѧ�֣�${stu.courses[1].creditHour } <br>
	
	<%=((Student)request.getAttribute("stu")).getName() %>
	<%=((Student)request.getAttribute("stu")).getCourses()[0].getCourseName() %>
	
	${stu['name'] }
</body>
</html>