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
		// 获取当前登录用户
		String user = (String)session.getAttribute("username");
		if (user == null) {
			response.sendRedirect("http://localhost:8080/chap5/example/ex55/login.html"); // 用户未登录，跳转到登录页面
			return;
		}
		
		// 获取用户提交的评论内容
		request.setCharacterEncoding("UTF-8");
		String interest = request.getParameter("interest");
		int score = Integer.parseInt(request.getParameter("score"));
		String comment = request.getParameter("comment");
		
		// 获取当前评论列表
		List<Message> list = (List<Message>)application.getAttribute("message");
		if (list == null) {
			list = new ArrayList<Message>();
		}
		
		// 检查该用户是否已经提交过评论
		boolean hasCommented = false;
		for (Message m : list) {
			if (m.getUser().equals(user)) {
				hasCommented = true;
				break;
			}
		}
		
		if (hasCommented) {
			out.print("您已经提交过评论，不能重复评论！");
		} else {
			// 用户第一次评论，保存评论信息
			Message msg = new Message(list.size() + 1, user, score, interest, comment, new Date(), 1);
			list.add(msg);
			application.setAttribute("message", list);
			response.sendRedirect("list.jsp");
		}
	%>
</body>
</html>
