<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>��ȡע����Ϣ</title>
</head>
<body>
	<c:set var="interests"  value="${paramValues.hobby }"/>
	<c:if test="${!empty interests}" var="res">
		�û�ѡ��Ĺ�ע������<br>
		${fn:join(interests,"��") }
	</c:if>
	<c:if test="${!res}"  >
		�û�δ��ע�κ���Ϣ
	</c:if>
</body>
</html>