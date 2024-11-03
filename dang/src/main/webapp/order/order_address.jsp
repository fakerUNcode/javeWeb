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
			生成订单骤: 1.确认订单 >
			<span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
		</div>
		
		<div class="fill_message">
		
			<form name="ctl00" method="post" action="" id="form_id">
				<input type="hidden" name="userId" id="userId" /> 

				<table class="tab_login">
					<tr>
						<td valign="top" class="w2">
							收件人姓名：
						</td>
						<td>
							<input type="text" class="text_input" name="receiveName"  id="receiveName"  />
							<div class="text_left" id="nameValidMsg">
								<p>
									请填写有效的收件人姓名
								</p>
								<span id="name_warning" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w2">
							收件人详细地址：
						</td>
						<td>
							<input type="text" name="fullAddress" class="text_input" id="fullAddress" />
							<div class="text_left" id="addressValidMsg">
								<p>
									请填写有效的收件人的详细地址
								</p>
								<span id="address_warning" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w2">
							邮政编码：
						</td>
						<td>
							<input type="text" class="text_input" name="postalCode"	id="postalCode" />
							<div class="text_left" id="codeValidMsg">
								<p>
									请填写有效的收件人的邮政编码
								</p>
								<span id="code_warning" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w2">
							电话：
						</td>
						<td>
							<input type="text" class="text_input" name="phone"	id="phone" "/>
							<div class="text_left" id="phoneValidMsg">
								<p>
									请填写有效的收件人的电话
								</p>
								<span id="phone_warning" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w2">
							手机：
						</td>
						<td>
							<input type="text" class="text_input" name="mobile"	id="mobile" />
							<div class="text_left" id="mobileValidMsg">
								<p>
									请填写有效的收件人的手机
								</p>
								<span id="mobile_warning" style="color:red"></span>
							</div>
						</td>
					</tr>
				</table>
				<br/>
				<br/>
				<div class="login_in">
					<input id="prev"  type="button" style="margin-left:0;"  value="上一步" onclick=""/>
					<input id="next"  type="button" style="margin-left:0;"  value="下一步" />
				</div>
			</form>
		</div>
	</body>
</html>

