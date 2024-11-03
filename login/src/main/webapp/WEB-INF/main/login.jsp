<%@page contentType="text/html;charset=utf-8" %>
<html>
<head>
	<title>登录</title>
</head>
<body>
<form method="post" action="checkLogin.do">
	<fieldset style="width:260px;">
		<legend>登录</legend>
		<span>用户名：</span><input type="text" name="name" /><br><br> 
		<span>密    码：</span><input type="password" name="pwd" /><br><br> 
		<div><input type="submit" value="登录" id="login"/></div>
	</fieldset>
</form>
</body>
</html>