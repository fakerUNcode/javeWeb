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
							<h3>ע&nbsp;��</h3>
						</div>
					</dt>
					<dt></dt>
					<dt>
						<div class='letter'>
							��&nbsp;&nbsp;&nbsp;��:&nbsp;<input type="text" name="email" id="email" 
							placeholder="��������������" tabindex='2'/>
							<div class='warning' id='warning_email'></div>
						</div>
					</dt>
					<dt>
						<div class='letter'>
							��&nbsp;&nbsp;&nbsp;��:&nbsp;<input type="text" name="nickname" id="nickname" tabindex='3'/>
						</div>
					</dt>
					<dt>
						<div class='letter'>
							��&nbsp;&nbsp;&nbsp;��:&nbsp;<input type="password" name="password" 
							placeholder="��ĸ�����������6λ" id="password" tabindex='4'/>
							<div class='warning' id='warning_password'></div>
						</div>
					</dt>
					<dt>
						<div class='password'>
							&nbsp;&nbsp;&nbsp;ȷ������:&nbsp;<input type="password" name="" id="final_password" tabindex='5'/>
							<div class='warning' id='warning_final_password'></div>
						</div>
					</dt>
					<dt>
						<div class='letter'>
							��֤��:&nbsp;<input type="text" name="verifycode" id="verifycode" placeholder="����ͼƬ������֤��" tabindex='6'/>
							<img class="" id='imgVcode' src="getVerifyCode.do" />							
							<div class='warning' id='warning_verifycode'></div>
						</div>
					</dt>
					<dt>
						<div>
							<input type="submit" class="submit" name="" value='&nbspע&nbsp��&nbsp' tabindex='7'/>
						</div>
					</dt>
				</dl>
			</div>
		</div>
		</form>
	</body>
</html>