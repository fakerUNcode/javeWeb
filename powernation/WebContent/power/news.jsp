<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<head>
	<meta charset="UTF-8">
	<title></title>
	<link type="text/css" rel="stylesheet" href="power/css/main.css" />
</head>
<body>
	<div class="container">
		<div class="top_logo">学习强国</div>
		<div class="top_title"><span>新闻动态</span></div>
		<div class="line"></div>
		<ul class="link">
			<li class=""><a href="#">图文</a></li>
			<li class="active"><a  href="#">列表</a></li>
		</ul>
		<div class="news">
				<ul class="left">
				<c:forEach items="${news}" var="n" begin="0" end="9">
					<li><a href="#">${n.title }</a>
						<span>${n.date}</span></li>					
				</c:forEach>
				</ul>
				<ul class="right">
					<c:forEach items="${news}" var="n" begin="10" end="19">
					<li><a href="#">${n.title }</a>
						<span>${n.date}</span></li>					
				</c:forEach>
				</ul>
		</div>
		<ul class="foot">
			<li class="active"><a href="">1</a></li>
			<li><a href="find.do">2</a></li>
			<li><a href="">3</a></li>
			<li><a href="">4</a></li>
			<li><a href="">>></a></li>
			<li><a href="">146</a></li>
		</ul>
	</div>
	</body>
	</html>