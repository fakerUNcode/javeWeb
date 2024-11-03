<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<title>添加商品</title>
	</head>
<body>
	<form action="add.do" method="post">
		<fieldset style="width:300px">
			<legend>添加商品</legend>
			商品名称：<input name="name" /><br><br> 
			描述信息：<input name="describe" /><br><br> 
			商品价格：<input name="price" /><br><br> 
			<input type="submit" value="添加" />
		</fieldset>
	</form>
</body>
</html>