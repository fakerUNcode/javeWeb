<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="GBK" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="../css/login.css"/>
	<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
	<script charset="utf-8"  type="text/javascript" src="../js/check_registe.js"></script>
</head>
	<body>
		<form id="form" method="post" action="registe.do">
		<div class="global">
			<div class="sig" id='zc'>
				<dl>
					<dt>
						<div class='header'>
							<h3>注&nbsp;册</h3>
						</div>
					</dt>
					<dt></dt>
					<dt>
						<div class='letter'>
							邮&nbsp;&nbsp;&nbsp;箱:&nbsp;<input type="text" name="email" id="email" 
							placeholder="请输入您的邮箱" tabindex='2'/>
							<div class='warning' id='warning_email'></div>
						</div>
					</dt>
					<dt>
						<div class='letter'>
							昵&nbsp;&nbsp;&nbsp;称:&nbsp;<input type="text" name="nickname" id="nickname" tabindex='3'/>
						</div>
					</dt>
					<dt>
						<div class='letter'>
							密&nbsp;&nbsp;&nbsp;码:&nbsp;<input type="password" name="password" 
							placeholder="字母数字组成至少6位" id="password" tabindex='4'/>
							<div class='warning' id='warning_password'></div>
						</div>
					</dt>
					<dt>
						<div class='password'>
							&nbsp;&nbsp;&nbsp;确认密码:&nbsp;<input type="password" name="" id="final_password" tabindex='5'/>
							<div class='warning' id='warning_final_password'></div>
						</div>
					</dt>
					<dt>
						<div class='letter'>
							验证码:&nbsp;<input type="text" name="verifycode" id="verifycode" placeholder="单击图片更换验证码" tabindex='6'/>
							<img class="" id='imgVcode' src="getVerifyCode.do" />							
							<div class='warning' id='warning_verifycode'></div>
						</div>
					</dt>
					<dt>
						<div>
							<input type="submit" class="submit" name="" value='&nbsp注&nbsp册&nbsp' tabindex='7'/>
						</div>
					</dt>
				</dl>
			</div>
		</div>
		</form>
	</body>
</html>