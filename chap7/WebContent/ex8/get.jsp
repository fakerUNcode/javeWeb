<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>获取注册信息</title>
</head>
<body>
	<c:set var="interests"  value="${paramValues.hobby }"/>
	<c:if test="${!empty interests}" var="res">
		用户选择的关注包括：<br>
		${fn:join(interests,"，") }
	</c:if>
	<c:if test="${!res}"  >
		用户未关注任何信息
	</c:if>
</body>
</html>