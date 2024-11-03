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
        // 模拟用户名和密码
        Map<String, String> users = new HashMap<String, String>();
        users.put("song", "123456");
        users.put("alice", "password1");
        users.put("bob", "password2");
        users.put("charlie", "password3");
        users.put("user1", "1");
        users.put("user2", "2");
        users.put("user3", "3");
        users.put("user4", "4");
        

        // 获取请求中的用户名和密码
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");

        // 验证用户名和密码
        if (users.containsKey(username) && users.get(username).equals(pwd)) {
            // 登录成功，转发到欢迎页面
            session.setAttribute("username", username);
            response.sendRedirect("../../drugGod/add.html");
        } else {
            // 登录失败，重定向回登录页面
            response.sendRedirect("login.html");
        }
    %>
</body>
</html>
