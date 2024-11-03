<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="GBK"%>
<%@ page autoFlush="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>设置response的MIME类型</title>
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
			<h1>out内置对象</h1>
		  <%
		  out.println("静夜思静夜思");
		    //out.println("<h2>静夜思</h2>");
		    //out.println("床前明月光<br>");
		   // out.println("疑是地上霜<br>");
		    //out.flush();
		    //out.clear();//这里会抛出异常。
		    //out.clearBuffer();//这里不会抛出异常。
		    //out.println("举头望明月<br>");
		   // out.println("低头思故乡<br>");
		   
		  %>
		    缓冲区大小：<%=out.getBufferSize() %>byte<br>
		    缓冲区剩余大小：<%=out.getRemaining() %>byte<br>
		    是否自动清空缓冲区：<%=out.isAutoFlush() %><BR> 
	%>

</body>
</html>