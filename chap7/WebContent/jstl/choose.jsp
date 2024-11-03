<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>choose±Í«©</title>
</head>
<body>
	<c:set var="gpa" value="c" scope="request"/>
	º®µ„£∫<c:choose>
		<c:when test="${gpa=='A'}" >4.0</c:when>
		<c:when test="${gpa=='A-'}" >3.7</c:when>
		<c:when test="${gpa=='B+'}" >3.3</c:when>
		<c:when test="${gpa=='B'}" >3.0</c:when>
		<c:otherwise>&lt;3</c:otherwise>
	</c:choose>
</body>
</html>
