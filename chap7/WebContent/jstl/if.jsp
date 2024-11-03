<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ page import="bean.Teacher" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>if标签</title>
</head>
<body>
	<%
		Teacher t = new Teacher();
		t.setName("song");
		t.setGender("female");
		request.setAttribute("teacher", t);
	%>
	姓名：${teacher.name }  <br> 
	性别：<c:if test="${teacher.gender=='male'}" var="result" scope="request">
		男
	</c:if>
	<c:if  test="${!result}" >
		女
	</c:if>
	
</body>
</html>

