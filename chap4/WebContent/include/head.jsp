<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<title></title>
</head>
<body>
	<div class="header_con">
		<div class="header">
			<div class="welcome fl">��ӭ������������!</div>
			<div class="user_info fr">
				<%
					String username = "����";	//�ѵ�¼�û���
					boolean isLogined = false;	//�Ƿ��¼��־
					if(isLogined){
				%>
				<div class="user_welcome fl">
					��ӭ����<em><%=username %></em>
				</div>
				<%
					}else{
				%>
				<div class="user_login_link fl">
					<a href="#">��¼</a>
					<span>|</span>
					<a href="#">ע��</a>
				</div>
				<%
					}
				%>
				
				<div class="user_shopping fl">
					<span>|</span>
					<a href="#">�ҵĹ��ﳵ</a>
					<span>|</span>
					<a href="#">�ҵĶ���</a>
				</div>
			</div>
		</div>
	</div>
		<div class="logo_bar">
		<div class="logo fl">
			<a href="#"><img src="images/logo.png"></a>
		</div>
		<div class="search fl">
			<input type="text" name="" placeholder="����" class="input_text fl">
			<input type="button" name="" value="����" class="input_btn fr">
		</div>
		<div class="chart fr">
			<a href="#" class="fl">�ҵĹ��ﳵ</a>
			<span class="fr">0</span>
		</div>
	</div>
</body>
</html>