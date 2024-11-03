<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="GBK"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>显示服务器时间</title>
</head>
<body>
	<%
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
	%>
	<%= sdf.format(now) %>
</body>
</html>

