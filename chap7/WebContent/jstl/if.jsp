<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ page import="bean.Teacher" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>if��ǩ</title>
</head>
<body>
	<%
		Teacher t = new Teacher();
		t.setName("song");
		t.setGender("female");
		request.setAttribute("teacher", t);
	%>
	������${teacher.name }  <br> 
	�Ա�<c:if test="${teacher.gender=='male'}" var="result" scope="request">
		��
	</c:if>
	<c:if  test="${!result}" >
		Ů
	</c:if>
	
</body>
</html>

