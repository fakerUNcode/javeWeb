<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>µÇÂ¼</title>
</head>
<body>
	<fieldset>
	 <form method="post" action="<%=response.encodeURL("login") %>"  >
		<legend>µÇÂ¼</legend>
			<span>username£º</span>
			<input type="text"  name="username"/>
			<span>password£º</span>
			<input type="password" name="pwd"/> 
			<input  type="submit" value="µÇÂ¼">
	 </form>
	</fieldset>
</body>
</body>
</html>