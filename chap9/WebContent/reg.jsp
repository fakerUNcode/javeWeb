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
	out.print("ÓÃ»§Ãû£º"+code+"<br/>");
	if(sex.equals("male")){
		out.print("ÐÔ±ð£ºÄÐ<br/>");
	}else{
		out.print("ÐÔ±ð£ºÅ®<br/>");
	}				
	out.print("Äã¶©ÔÄµÄÄÚÈÝ°üÀ¨:<br/>");		
	if(hobbies!=null){ 
		String h=null;
		for(String hobby: hobbies){
			switch(hobby){
				case "computer": h="¼ÆËã»ú"; break;
				case "finance":  h="½ðÈÚ"; break;
				case "language": h="ÍâÓï"; break;
			}
			out.print(h+"<br/>");		
		}
	}


%>
</body>
</html>