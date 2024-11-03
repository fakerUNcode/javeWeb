<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>

<%
	String pwd1 = request.getParameter("pwd1");
	String pwd2 = request.getParameter("pwd2");
	if(pwd1.length()==0 || pwd2.length()==0){
		out.println("密码不能为空");
	}else{
		if(pwd1.equals(pwd2)){
			out.println("OK,两次密码相同");
		}else{
			out.println("两次密码不同,重新输入");
		}
	}
%>