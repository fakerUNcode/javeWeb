<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%
		out.print("<h3>��������ʼ��"+out.getBufferSize()+"�ֽ�</h3>");
		out.print("<h4>��Ǯ�������С����ơ��׾���</h4>");
		out.print("<h4>��ɽ�±���ͤ����ˮ���ƽ�ƽŵ͡�</h4>");
		out.print("<h4>������ݺ��ů����˭�������Ĵ��ࡣ</h4>");
		out.print("<h3>������ʣ�ࣺ"+out.getRemaining()+"�ֽ�</h3>");
		out.flush();
		out.print("<h3>������ˢ�º�"+out.getRemaining()+"�ֽ�</h3>");		
		out.print("<h4>�һ����������ۣ�ǳ�ݲ���û���㡣</h4>");
		out.print("<h4>������в��㣬���������ɳ�̡�</h4>");
	%>
</html>
