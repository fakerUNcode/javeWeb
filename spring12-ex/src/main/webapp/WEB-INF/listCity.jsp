<%@ page  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>城市信息列表</title>
	<style type="text/css">
		td{
			text-align:center;
		}
	</style>
</head>
<body>
	<table border='1' cellpadding='0' cellspacing='0' width='20%'>
		<caption>城市列表</caption>
		<tr>
			<td>ID</td>
			<td>城市</td>
		</tr>
		<c:forEach var="city" items="${listCity}">
			<tr>
				<td>${city.id}</td>
				<td>${city.name}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>