<%@page contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<title>首页</title>
	</head>
	<body>
    		欢迎，${user.name}
    		<%
    			out.print(session.getAttribute("user"));
    		%>
	</body>
</html>