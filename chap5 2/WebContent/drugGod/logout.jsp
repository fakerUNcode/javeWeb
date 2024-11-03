<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%
    // 清除用户的会话数据
    session.invalidate();
    // 重定向到登录页面
    response.sendRedirect("../example/ex55/login.html");
%>
