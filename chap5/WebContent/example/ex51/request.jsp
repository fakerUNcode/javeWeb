<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="GBK"%>
<%@ page import="java.util.Enumeration"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ʹ��reqeust��ȡ�ͻ���������Ϣ</title>
</head>
<body>
	<%
		//��ȡ�����е���Ϣ
		out.print("����ʽ��" + request.getMethod() + "<br/>");
		out.print("�����Э�����ࣺ" + request.getProtocol() + "<br/>");
		out.print("������Դ·��(URI)��" + request.getRequestURI() + "<br/>");
		//�鿴����·����ʾ	
		out.print("�����·����Ϣ(URL)��" + request.getRequestURL() + "<br/>");
		out.print("�����WebӦ��·����" + request.getContextPath() + "<br/>");
		out.print("����ķ������˳���·����" + request.getServletPath() + "<br/>");
		//�鿴�ͻ��˵�IP��ַ
		out.print("����������û�IP��ַ��" + request.getRemoteAddr() + "<br/>");
		//��ȡ������Ϣͷ�����ƣ������б���
		Enumeration e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			//����Enumeration��ȡÿһ����Ϣͷ������
			String headerName = e.nextElement().toString();
			//�����Ϣͷ����-ֵ�Զ���Ϣ
			out.print(headerName + "��" + request.getHeader(headerName) + "<br/>");
		}
	%>

</body>
</html>