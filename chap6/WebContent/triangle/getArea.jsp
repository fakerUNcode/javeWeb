<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="gbk"%>
<%@ page import="java.text.DecimalFormat" %>

<jsp:useBean id="tri" scope="request" class="cal.TriangleBean"/>
<%
	try{
		double a = Double.parseDouble(request.getParameter("a"));
		double b = Double.parseDouble(request.getParameter("b"));
		double c = Double.parseDouble(request.getParameter("c"));
		tri.setA(a);
		tri.setB(b);
		tri.setC(c);	
		out.print(tri.getArea());
	}catch(Exception e){
		out.println("您输入的三边长有误");
	}
%>