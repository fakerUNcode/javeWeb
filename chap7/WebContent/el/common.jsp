<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ page import="bean.Student,bean.Course" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Insert title here</title>
</head>
<body>
	<c:set var="stu" value="<%=new Student() %>" scope="request"/>	
	<c:set target="${stu}" property="name" value="Lucy"/>
	<c:set target="${stu}" property="grade" value="2"/>
	
	${stu.name }	
	<c:out value="${stu.name }"/>
	<c:out value="<%= ((Student)request.getAttribute("stu")).getName() %>"/>
	
	<c:remove var="stu" scope="request" />
	<c:out value="${stu.name }" default="unknown"/>
</body>
</html>