<%@page contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<title>出错页面</title>
	</head>
	<body>
    		出错了，${message}
    		<%
    			response.setHeader("refresh", "2; url=toLogin.do");
    		%>
	</body>
</html>
