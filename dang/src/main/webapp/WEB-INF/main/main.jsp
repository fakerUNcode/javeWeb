<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>网上书店</title>
		<link href="<%=request.getContextPath() %>/css/book.css" rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath() %>/css/second.css" rel="stylesheet" type="text/css" />
	</head>
	<body style="background:#fff;">
		&nbsp;
		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->
		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<c:import url="/main/getCategory.do"></c:import>
			</div>	
			
			<!--中栏开始-->
			<div class="book_center">

				<!--推荐图书开始-->
				<div class=second_c_border1 id="recommend">
					<c:import url="/main/recommend.do?size=2"></c:import>
				</div>
				<!--推荐图书结束-->
				
			</div>
			<!--中栏结束-->
			
			<!--右栏开始-->
			<div class="book_right">
				<div class="book_r_border2" id="__XinShuReMai">
					<div class="book_r_b2_1x" id="new_bang">
					
						<h2 class="t_xsrm"> 热卖榜</h2>
							<c:import url="/main/hot.do?size=10"></c:import>
						<div id="NewProduct_1_o_t">
							<h3>
								<span class="dot_r"> </span><a href="#" target="_blank">更多&gt;&gt;</a>
							</h3>
						</div>
					</div>
				</div>
			</div>
			<!--右栏结束-->
			
			<div class="clear"></div>
		</div>
	</body>
</html>
