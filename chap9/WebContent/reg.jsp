<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	String code = request.getParameter("code");
	String sex = request.getParameter("sex");		
	String[] hobbies = request.getParameterValues("hobby");
	
	response.setContentType("text/html");
	out.print("用户名："+code+"<br/>");
	if(sex.equals("male")){
		out.print("性别：男<br/>");
	}else{
		out.print("性别：女<br/>");
	}				
	out.print("你订阅的内容包括:<br/>");		
	if(hobbies!=null){ 
		String h=null;
		for(String hobby: hobbies){
			switch(hobby){
				case "computer": h="计算机"; break;
				case "finance":  h="金融"; break;
				case "language": h="外语"; break;
			}
			out.print(h+"<br/>");		
		}
	}


%>
</body>
</html>