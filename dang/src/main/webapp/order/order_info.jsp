<%@page contentType="text/html;charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/order.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<%@include file="../common/head.jsp"%>
		<div class="login_step">
			生成订单骤:
			<span class="red_bold">1.确认订单</span> > 2.填写送货地址 > 3.订单成功
		</div>
		<div class="fill_message">

			<table class="tab_login">
				<tr>
					<td valign="top" class="w1">
						<b>序号</b>
					</td>
					<td valign="top" class="w1">
						<b>商品名称</b>
					</td>
					<td valign="top" class="w1">
						<b>商品单价</b>
					</td>
					<td valign="top" class="w1">
						<b>商品数量</b>
					</td>
					<td valign="top" class="w1">
						<b>小计</b>
					</td>
				</tr>

				<!-- 订单开始 -->
				<tr>
					<td valign="top" style="text-align:center;">  
						1
					</td>
					<td valign="top">
						机器学习
					</td>
					<td valign="top"  style="text-align:center;">
						83.6
					</td>
					<td valign="top"  style="text-align:center;">
						1
					</td>
					<td valign="top"  style="text-align:center;">
						83.60
					</td>
				</tr>
				<tr>
					<td valign="top"  style="text-align:center;">  
						2
					</td>
					<td valign="top">
						利用Python进行数据分析（原书第2版）[Python for Data Analysis: Data Wrangling with Pand]
					</td>
					<td valign="top"  style="text-align:center;">
						113.10
					</td>
					<td valign="top"  style="text-align:center;">
						1
					</td>
					<td valign="top"  style="text-align:center;">
						113.10
					</td>
				</tr>
				<!-- 订单结束 -->
				<tr>
					<td valign="top" class="w1" style="text-align: left" colspan="5">
						<b>总价￥196.70</b>
					</td>
				</tr>
			</table>
			<br />
			<div class="login_in">

				<input id="prev"  
					type="submit" style="margin-left:0;" value="上一步" onclick=""/>
				<input id="next" 
					type="submit" style="margin-left:0;" value="下一步" onclick=""/>
			</div>

		</div>
	</body>
</html>

