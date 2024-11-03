<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>主页</title>
</head>
<body>
	<%--当前共有<%=application.getAttribute("count").toString()%>人在线<br><br/>
	当前共有${count}人在线<br><br/>  --%> 
	
	<c:set var="user" value="${user}" scope="session"/>
	<c:if test="${user!=null }" var="result">
		你好，${sessionScope.user}  <br/><br/>
		<a href="/chap9/logout.do">退出登录</a><br/><br/>
		<a href="/chap9/getcart.do">查看购物车</a><br/><br/>
		<a href="/chap9/getorder.do">结账</a>
	</c:if>
	<c:if test="${!result}">
		<a href="/chap9/login.html">登录</a>
	</c:if>	
</body>
</html>