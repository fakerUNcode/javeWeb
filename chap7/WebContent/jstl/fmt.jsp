<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>I18N</title>
</head>
<body>
	<!-- <fmt:setLocale value="zh_CN"/> -->
	<fmt:setLocale value="en_US"/>
	
	<fmt:formatNumber value="199" type="currency"/>
	<fmt:formatNumber value="199" pattern=".00" type="number"/>
	<fmt:formatNumber value="${1/3}" type="percent" maxFractionDigits="0"/>
	
	<c:set var="now"  value="<%=new java.util.Date() %>"/>
	<fmt:formatDate value="${now}" type="both"/> <br>
	<fmt:formatDate value="${now}" type="date"/> <br>
	<fmt:formatDate value="${now}" type="time"/> <br>
	
	<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" />
	
</body>
</html>