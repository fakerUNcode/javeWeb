<%@ page pageEncoding="GBK"%>
<%@ page import="tempmis.TempReport,java.util.List, java.text.DecimalFormat" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//获取Servlet传递过来的数据
		List<TempReport> list =  (List)request.getAttribute("list");
	%>
	<table border='1px' cellpadding='10' cellspacing='0'>
		<tr>
			<th>序号</th>	
			<th>姓名</th>
			<th>电话</th>
			<th>14天内是否有湖北接触史</th>
			<th>日期</th>
			<th>体温</th>
		</tr>		
		<%
			for(TempReport t: list){
		%>
		<tr>
			<td><%=t.getId() %></td>
			<td><%=t.getName() %></td>
			<td><%=t.getTelephone() %></td>
		<%
			if(t.getIsContacted()==1){
		%>
			<td style='text-align:center'>是</td>
		<%
			}else{
		%>
			<td style='text-align:center'>否</td>
		<%
			}
		%>
			<td><%=t.getDate() %></td>
			<td><%= new DecimalFormat("00.00").format(t.getTemp()) %></td>
		</tr>
		<%
			}
		%>
	</table>
	<br>
	<input type="button" value="添加新数据" 
				onclick="location.href='tmp/addTemp.html'">
</body>
</html>