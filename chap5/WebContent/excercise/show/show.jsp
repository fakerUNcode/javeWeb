<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<style>
body {
	background-color: cyan;
	font-size: 20px;
}
</style>
</head>
<body>
	<%
		String s1 = request.getParameter("image");
		String s2 = request.getParameter("video");
	%>
	<image src="picture/<%=s1%>" width=200 height=160>选择一幅图像</image>
	<embed src="avi/<%=s2%>" width=300 height=180>
	选择视频或音乐
	</embed>
</body>
</html>
