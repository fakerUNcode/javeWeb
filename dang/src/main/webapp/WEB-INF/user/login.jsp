<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="GBK" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="../css/login.css"/>
	<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
	<script charset="utf-8"  type="text/javascript" src="../js/check_login.js"></script>

</head>
	<body>
	<form id="form" method="post" action="login.do">
		<div class="global">
			<div class="log log_in" id='dl'>
				<dl>
					<dt>
						<div class='header'>
							<h3>��&nbsp;¼</h3>
						</div>
					</dt>
					<dt></dt>
					<dt>
						<div class='letter'>
							��&nbsp;&nbsp;&nbsp;��:&nbsp;
							<input type="text" name="email" id="email" tabindex='1'/>
						    <div class='warning' id='warning_email'></div>
						</div>
					</dt>
					<dt>
						<div class='letter'>
							��&nbsp;&nbsp;&nbsp;��:&nbsp;
							<input type="password" name="password" id="password" tabindex='2'/>
						    <div class='warning' id='warning_password'></div>
						</div>
					</dt>
					<dt>
						<div>
							<input type="submit" name="" value='&nbsp��&nbsp¼&nbsp' tabindex='3'/>
						</div>
					</dt>
				</dl>
			</div>
		</div>
		</form>
	</body>
</html>