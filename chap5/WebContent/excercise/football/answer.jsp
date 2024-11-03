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

       if(countryName.equals("巴西")){
           score++;
       }
       if(itemNames==null){
           out.print("选项为空<br>");
       }else if(itemNames.length>=2){
          if(itemNames[0].equals("法国") && itemNames[1].equals("西班牙")&& itemNames[2].equals("巴西")){
               score++;
          }
       }
       %>
</body>