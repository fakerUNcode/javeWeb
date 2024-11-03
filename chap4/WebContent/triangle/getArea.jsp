<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="gbk"%>
<%@ page import="java.text.DecimalFormat" %>

<%
	try{
		double a = Double.parseDouble(request.getParameter("a"));
		double b = Double.parseDouble(request.getParameter("b"));
		double c = Double.parseDouble(request.getParameter("c"));
	
		if(a>0 && b>0 && c>0 && a+b>c && b+c>a && a+c>b){
			double s = (a + b + c) / 2;
			double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
			
			out.println(new DecimalFormat("##0.00").format(area));
		} else{
			out.println("您输入的三边长有误");
		}
	}catch(Exception e){
		out.println("您输入的三边长有误");
	}
%>
