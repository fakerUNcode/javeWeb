<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="GBK"%>
<%@ page autoFlush="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>����response��MIME����</title>
</head>
<body>
	<table>
		
		<tr>
			<th>1</th><th>2</th>
		</tr>
	</table>
	
	<%
		/*String str = request.getParameter("submit");
		if(str.equals("yes")){
			response.addHeader("content-disposition","attachment; filename=download.doc");
		}*/
		//System.out.println(out.isAutoFlush());
	%>
			<h1>out���ö���</h1>
		  <%
		  out.println("��ҹ˼��ҹ˼");
		    //out.println("<h2>��ҹ˼</h2>");
		    //out.println("��ǰ���¹�<br>");
		   // out.println("���ǵ���˪<br>");
		    //out.flush();
		    //out.clear();//������׳��쳣��
		    //out.clearBuffer();//���ﲻ���׳��쳣��
		    //out.println("��ͷ������<br>");
		   // out.println("��ͷ˼����<br>");
		   
		  %>
		    ��������С��<%=out.getBufferSize() %>byte<br>
		    ������ʣ���С��<%=out.getRemaining() %>byte<br>
		    �Ƿ��Զ���ջ�������<%=out.isAutoFlush() %><BR> 
	%>

</body>
</html>