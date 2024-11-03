<%@page contentType="text/html;charset=utf-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>${book.productName}-图书网</title>
<link href="../product/css/book.css" rel="stylesheet" type="text/css" />
<link href="../product/css/comm_answer.css" rel="stylesheet"
	type="text/css" />
<link href="../product/css/product_exp.css" rel="stylesheet"
	type="text/css" />
<script src="../js/jquery-1.12.4.js"></script>
</head>

<body>
	&nbsp;
	<!-- 头部开始 -->
	<%@include file="../common/head.jsp"%>
	<!-- 头部结束 -->

	<div class="mainsearch"></div>
	<div class="wrap">
		<div class="right">
			<div class="right_wai">
				<%@include file="product_detail.jsp"%>
			</div>
		</div>

		<div class="clear"></div>
	</div>
</body>
</html>