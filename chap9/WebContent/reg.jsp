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
	out.print("�û�����"+code+"<br/>");
	if(sex.equals("male")){
		out.print("�Ա���<br/>");
	}else{
		out.print("�Ա�Ů<br/>");
	}				
	out.print("�㶩�ĵ����ݰ���:<br/>");		
	if(hobbies!=null){ 
		String h=null;
		for(String hobby: hobbies){
			switch(hobby){
				case "computer": h="�����"; break;
				case "finance":  h="����"; break;
				case "language": h="����"; break;
			}
			out.print(h+"<br/>");		
		}
	}


%>
</body>
</html>