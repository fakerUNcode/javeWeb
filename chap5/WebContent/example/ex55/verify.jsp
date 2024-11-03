<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
    <%
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");

        if ("admin".equals(username) && "123456".equals(pwd)) {
            // 登录成功，设置会话属性
            session.setAttribute("loggedIn", "true");
            session.setAttribute("username", username);
            // 重定向到 add.html
            response.sendRedirect(request.getContextPath() + "/drugGod/add.html");
        } else {
            // 登录失败，重定向回登录页面
            response.sendRedirect(request.getContextPath() + "/example/ex55/login.html");
        }
    %>
</body>
</html>
