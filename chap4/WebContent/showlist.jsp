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
		//��ȡServlet���ݹ���������
		List<TempReport> list =  (List)request.getAttribute("list");
	%>
	<table border='1px' cellpadding='10' cellspacing='0'>
		<tr>
			<th>���</th>	
			<th>����</th>
			<th>�绰</th>
			<th>14�����Ƿ��к����Ӵ�ʷ</th>
			<th>����</th>
			<th>����</th>
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
			<td style='text-align:center'>��</td>
		<%
			}else{
		%>
			<td style='text-align:center'>��</td>
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
	<input type="button" value="���������" 
				onclick="location.href='tmp/addTemp.html'">
</body>
</html>