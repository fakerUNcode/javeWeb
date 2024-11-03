<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ page import="forum.Message,java.util.Date,java.util.List,java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Insert title here</title>

</head>
<body>
	<%
		String user = (String)session.getAttribute("username");  //ÒÑµÇÂ¼ÓÃ»§
		request.setCharacterEncoding("UTF-8");
		String interest = request.getParameter("interest");
		int score = Integer.parseInt(request.getParameter("score"));
		String comment = request.getParameter("comment");
		
		List<Message> list = (List<Message>)application.getAttribute("message");
		if(list==null){
			list = new ArrayList<Message>();
		}
		
		Message msg = new Message(list.size()+1,user,score,interest,comment,new Date(),1);		
		
		list.add(msg);
		application.setAttribute("message", list);
		response.sendRedirect("list.jsp");
	%>
</body>
</html>