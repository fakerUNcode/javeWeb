<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ page import="javax.servlet.http.Cookie" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>��ҳ</title>
</head>
<body>
	<%
		String name=null;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){			
			for(Cookie c:cookies){  //��Cookie���е���
				if(c.getName().equals("userName")){
					name=c.getValue();
				}
			}
		}
	%>
	<%
		if(name!=null){
	%>
		���, <%=name %>
		${cookie.userName.value }
	<%
		}else{
	%>
		<a href="login.html"> ��¼</a>
	<%
		}
	%>
	
</body>
</html>