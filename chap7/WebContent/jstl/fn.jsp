<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>fn标签</title>
</head>
<body>
	<c:set var="interests" value='${fn:split("游泳,打球,看书,逛商店", ",")}' />
	该用户的兴趣爱好包括：<br>
	<c:forEach items="${interests}" var="interest" varStatus="s">
		${s.count } &nbsp;&nbsp;  ${interest } <br>
	</c:forEach>
	
</body>
</html>