<%@page contentType="text/html;charset=utf-8" %>
<head>
	<meta charset="UTF-8" />
	<title>体温平安报</title>
</head>
<body>
	<h3>体温平安报</h3>
	<form method="post" action="tmp/add.do">
		  姓名：<input type ="text" name="name" /><br/><br/>
		  电话：<input type ="text" name="telephone" /><br/><br/>
		  最近14天是否有湖北接触史：<br/>
		  没有<input type ="radio" name="isContacted" value="1" checked/>
		  有<input type ="radio" name="isContacted" value="0" /><br/><br/>
		  体温：<input type ="text" name="temperature" /><br/><br/>
		<input type="submit" value="  上报  " />
	</form>
</body>
</html>

