<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ page import="java.util.Map, java.util.HashMap"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
    <%
        // ģ���û���������
        Map<String, String> users = new HashMap<String, String>();
        users.put("song", "123456");
        users.put("alice", "password1");
        users.put("bob", "password2");
        users.put("charlie", "password3");
        users.put("user1", "1");
        users.put("user2", "2");
        users.put("user3", "3");
        users.put("user4", "4");
        

        // ��ȡ�����е��û���������
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");

        // ��֤�û���������
        if (users.containsKey(username) && users.get(username).equals(pwd)) {
            // ��¼�ɹ���ת������ӭҳ��
            session.setAttribute("username", username);
            response.sendRedirect("../../drugGod/add.html");
        } else {
            // ��¼ʧ�ܣ��ض���ص�¼ҳ��
            response.sendRedirect("login.html");
        }
    %>
</body>
</html>
