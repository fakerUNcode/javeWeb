<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<title></title>
</head>
<body>
	<div class="header_con">
		<div class="header">
			<div class="welcome fl">欢迎来到天天生鲜!</div>
			<div class="user_info fr">
				<%
					String username = "海洋";	//已登录用户名
					boolean isLogined = false;	//是否登录标志
					if(isLogined){
				%>
				<div class="user_welcome fl">
					欢迎您：<em><%=username %></em>
				</div>
				<%
					}else{
				%>
				<div class="user_login_link fl">
					<a href="#">登录</a>
					<span>|</span>
					<a href="#">注册</a>
				</div>
				<%
					}
				%>
				
				<div class="user_shopping fl">
					<span>|</span>
					<a href="#">我的购物车</a>
					<span>|</span>
					<a href="#">我的订单</a>
				</div>
			</div>
		</div>
	</div>
		<div class="logo_bar">
		<div class="logo fl">
			<a href="#"><img src="images/logo.png"></a>
		</div>
		<div class="search fl">
			<input type="text" name="" placeholder="搜索" class="input_text fl">
			<input type="button" name="" value="搜索" class="input_btn fr">
		</div>
		<div class="chart fr">
			<a href="#" class="fl">我的购物车</a>
			<span class="fr">0</span>
		</div>
	</div>
</body>
</html>