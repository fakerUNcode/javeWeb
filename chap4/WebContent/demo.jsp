<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="GBK"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

</style>
</head>
<body>
	<a href="<%=request.getContextPath() %>/index.jsp">Ê×Ò³</a>
	<%= new java.util.Date() %>
	<%
		for(int i=0; i<26; i++){
	%>
			<a href="#"><%=(char)('A'+i) %></a>&nbsp;&nbsp;

	<%
		}
	%>
	<br/>
	<!-- ÉùÃ÷ -->
	<%!
		String timeFormat(int hour, int minute){
			if(hour>=0 && hour<=12){
				return hour+":"+ minute +" a.m.";
			}else{
				return hour%12+":"+ minute +" p.m.";
			}
		}		
	%>	
	<h3>departure time is <%= timeFormat(11,30) %>
	and arriving at <%=timeFormat(21,55) %></h3>
	
	</body>	
</html>