<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>��ҳ</title>
</head>
<body>
	<%--��ǰ����<%=application.getAttribute("count").toString()%>������<br><br/>
	��ǰ����${count}������<br><br/>  --%> 
	
	<c:set var="user" value="${user}" scope="session"/>
	<c:if test="${user!=null }" var="result">
		��ã�${sessionScope.user}  <br/><br/>
		<a href="/chap9/logout.do">�˳���¼</a><br/><br/>
		<a href="/chap9/getcart.do">�鿴���ﳵ</a><br/><br/>
		<a href="/chap9/getorder.do">����</a>
	</c:if>
	<c:if test="${!result}">
		<a href="/chap9/login.html">��¼</a>
	</c:if>	
</body>
</html>