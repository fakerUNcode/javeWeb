<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="GBK"%>
<%@ page import="java.util.Enumeration"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>使用reqeust获取客户端请求信息</title>
</head>
<body>
	<%
		//获取请求行的信息
		out.print("请求方式：" + request.getMethod() + "<br/>");
		out.print("请求的协议种类：" + request.getProtocol() + "<br/>");
		out.print("请求资源路径(URI)：" + request.getRequestURI() + "<br/>");
		//查看其它路径表示	
		out.print("请求的路径信息(URL)：" + request.getRequestURL() + "<br/>");
		out.print("请求的Web应用路径：" + request.getContextPath() + "<br/>");
		out.print("请求的服务器端程序路径：" + request.getServletPath() + "<br/>");
		//查看客户端的IP地址
		out.print("发起请求的用户IP地址：" + request.getRemoteAddr() + "<br/>");
		//获取所有消息头的名称，并进行遍历
		Enumeration e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			//遍历Enumeration获取每一个消息头的名称
			String headerName = e.nextElement().toString();
			//输出消息头的名-值对儿信息
			out.print(headerName + "：" + request.getHeader(headerName) + "<br/>");
		}
	%>

</body>
</html>