<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>��ҳ</title>
</head>
<body>
	<%
		String name = (String)session.getAttribute("userName");
		if(name!=null){
	%>
		���, <%=name %>	<br>	 
		<a href="/chap8/logout">�˳�(ֱ��д��Ŀ�ĸ�)</a>  <br>
		<a href="<%=request.getContextPath()%>/logout">�˳�(JSP���ʽ��ȡ��)</a>  <br> 
		<a href="${pageContext.request.contextPath}/logout">�˳�(EL���ʽ��ȡ��)</a>   <br>   
	<%
		}else{
	%>
		<a href="login.html"> ��¼</a>
	<%
		}
	%>
	
</body>
</html>