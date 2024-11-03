<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="gbk"%>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="net.sf.json.JSONObject" %>
<%@ page import="entity.Result" %>
<%
	Result r = new Result();	
	try{			
		double a = Double.parseDouble(request.getParameter("a"));
		double b = Double.parseDouble(request.getParameter("b"));
		double c = Double.parseDouble(request.getParameter("c"));
	
		if(a>0 && b>0 && c>0 && a+b>c && b+c>a && a+c>b){
			double s = (a + b + c) / 2;
			double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
			
			r.setStatus(0);
			r.setMsg(new DecimalFormat("##0.00").format(area));
		} else{
			r.setStatus(1);
			r.setMsg("您输入的三边长有误");
		}
		
	}catch(Exception e){
		r.setStatus(1);
		r.setMsg("您输入的三边长有误");
	}
	JSONObject  jsonObj =JSONObject.fromObject(r);
	out.print(jsonObj.toString());
%>
