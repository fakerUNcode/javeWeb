<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="GBK"%>
<%@ page import="java.util.List,java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>EL����</title>
</head>
<body>
	${1+2 } ${'123'+'456'} ${1 eq 1 } ${"abc" > "Abc"} ${3.0==3.0 }
	<br>
	<%
		request.setAttribute("str", "");
		request.setAttribute("list", new ArrayList());
		request.setAttribute("obj", null);
	%>
	���ַ�����${empty str} <br> 
	��������Ϊ�գ�${empty list } <br> 
	null�Ľ����${empty obj } <br> 
	�Ҳ�����������${empty xxx }<br><br>
	
	${pageContext.response.characterEncoding}
	${empty requestScope}
	
	
	<%
	String[] colors={"red","orange","yellow","green","cyan"};
%>

<c:forEach  items="<%=colors %>"  var="color"  begin="1"  end="4"  step="2"  >
	${color} &nbsp;
</c:forEach>
	
</body>
</html>