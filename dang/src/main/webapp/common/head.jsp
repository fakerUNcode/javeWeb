<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<link href="<%=request.getContextPath() %>/css/book_head.css" rel="stylesheet" type="text/css" />
<div class="head_container">
	<div class="head_welcome">
		<div class="head_welcome_right">
			<div class="cart">
				<a href="<%=request.getContextPath() %>/cart/cartlist.do">购物车</a>
			</div>
		</div>
		<span class="head_toutext" id="logininfo"> 
		<c:if test="${username==null}" var="res">
				<b>欢迎光临</b>
		     [&nbsp;<a href="<%=request.getContextPath() %>/user/toLogin.do" class="b">登录&nbsp;</a>|<a
					href="<%=request.getContextPath() %>/user/toRegiste.do" class="b">&nbsp;注册</a>&nbsp;]
		</c:if> 
		<c:if test="${!res}"> 
		      Hi，${username}
				<a href="exit.do" class="b">退出</a>
		</c:if>

		</span>
	</div>
	<div class="head_head_list">
		<div class="head_head_list_left">
			<span class="head_logo">
			</span>
		</div>
	</div>
</div>
