<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>��¼</title>
</head>
<body>
	<fieldset>
	 <form method="post" action="<%=response.encodeURL("login") %>"  >
		<legend>��¼</legend>
			<span>username��</span>
			<input type="text"  name="username"/>
			<span>password��</span>
			<input type="password" name="pwd"/> 
			<input  type="submit" value="��¼">
	 </form>
	</fieldset>
</body>
</body>
</html>