<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ page import="forum.Message,java.util.Date"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Insert title here</title>

</head>
<body>
	<jsp:useBean id="msgBean" class="forum.MessageBean" scope="application" />
	<%
		String user = (String)session.getAttribute("username");  //ÒÑµÇÂ¼ÓÃ»§
		request.setCharacterEncoding("UTF-8");
		String interest = request.getParameter("interest");
		int score = Integer.parseInt(request.getParameter("score"));
		String comment = request.getParameter("comment");
		
		int size = msgBean.getList().size();
		Message msg = new Message(size+1,user,score,interest,comment,new Date(),1);		
		msgBean.add(msg);
		response.sendRedirect("list.jsp");
	%>
</body>
</html>