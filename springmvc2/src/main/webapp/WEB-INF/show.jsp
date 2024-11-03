<%@page contentType="text/html;charset=utf-8" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
	<head>
		<title>上报体温数据</title>
	</head>
	<body>
    	<h1>姓名：${info.name}</h1>
    	<h1>联系方式：${info.telephone }</h1>    
    	<h1>与湖北是否有接触：
    	<c:if test="${info.isContacted}" var="res">
    		有接触</h1>
    	</c:if>
    	<c:if test="${!res }">
    		未有接触</h1>
    	</c:if>
    	</h1>
   	 	<h1>当日体温：${info.temperature }</h1>   	 	
	</body>
</html>