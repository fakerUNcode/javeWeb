<html>
<head>
	<title><%=titlename %></title>
</head>
<body>
	<%@ include file="head.jsp" %>
	
	<jsp:include page="<%=bodyfilename %>"  />

	<%@ include file="foot.html" %>
</body>

</html>