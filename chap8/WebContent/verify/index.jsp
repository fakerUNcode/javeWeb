<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ page import="javax.servlet.http.Cookie" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Ö÷Ò³</title>
</head>
<body>
	<%
		String name = (String)session.getAttribute("userName");
		if(name!=null){
	%>
		ÄãºÃ, <%=name %>	<br>	 
	<%
		}else{
	%>
		<a href="login.html"> µÇÂ¼</a>
	<%
		}
	%>
	
</body>
</html>