<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	try{
		Integer.parseInt("abc");
	}catch(Exception e){
		out.print("---");
	}
	//response.sendError(404, "我在做实验");
%>