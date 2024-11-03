<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>主页</title>
</head>
<body>
	<%
		String name = (String)session.getAttribute("userName");
		if(name!=null){
	%>
		你好, <%=name %>	<br>	 
		<a href="/chap8/logout">退出(直接写项目的根)</a>  <br>
		<a href="<%=request.getContextPath()%>/logout">退出(JSP表达式获取根)</a>  <br> 
		<a href="${pageContext.request.contextPath}/logout">退出(EL表达式获取根)</a>   <br>   
	<%
		}else{
	%>
		<a href="login.html"> 登录</a>
	<%
		}
	%>
	
</body>
</html>