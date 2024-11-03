<%@page contentType="text/html;charset=utf-8"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>订单提交</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/order.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<%@include file="../common/head.jsp"%>
		<div class="login_step">
			生成订单步骤: 1.确认订单 > 2.填写送货地址 >
			<span class="red_bold">3.订单成功</span>
		</div>


		<div class="login_success">
			<div class="login_bj">
				<div class="succ">
					<h2><b><span>提交成功！</span></b></h2>
				</div>
				<h5>
					订单已经生成
				</h5>
				<h6>
					您刚刚生成的订单号是：1111
				</h6>
				<h6>
					金额为：196.70
				</h6>
				<ul>					
					<li>
						<a href="">继续浏览并选购商品</a>
					</li>
				</ul>
			</div>
		</div>

	</body>
</html>

