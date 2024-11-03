<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ page import="forum.Message,java.util.Date,java.util.List"%>

<%
	int id = Integer.parseInt(request.getParameter("id"));
	List<Message> list= (List<Message>)application.getAttribute("message");
	
	for(Message m : list){
		if(m.getId()==id){
			m.setVote_count(m.getVote_count()+1);
			out.print(m.getVote_count());
		}
	}
	application.setAttribute("message", list);	
	
%>
