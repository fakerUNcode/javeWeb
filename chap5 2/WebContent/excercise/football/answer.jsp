<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Insert title here</title>
</head>
<body>
	 <%  int score=0;
   	   request.setCharacterEncoding("gbk");
       String countryName=request.getParameter("R"); 
       String itemNames[]=request.getParameterValues("item");

       if(countryName.equals("����")){
           score++;
       }
       if(itemNames==null){
           out.print("ѡ��Ϊ��<br>");
       }else if(itemNames.length>=2){
          if(itemNames[0].equals("����") && itemNames[1].equals("������")&& itemNames[2].equals("����")){
               score++;
          }
       }
       %>
</body>