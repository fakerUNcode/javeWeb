<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>

<jsp:useBean id="msgBean" class="forum.MessageBean" scope="application" />
<%
	int id = Integer.parseInt(request.getParameter("id"));
	out.print(msgBean.modifyVote(id));	
%>
