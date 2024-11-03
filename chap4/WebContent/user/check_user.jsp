<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="GBK"%>
<%@ page import="java.sql.*" %>

<%
	String username = request.getParameter("username");

	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con =  DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/temp?characterEncoding=utf8",
                "root", "1234");
		st = con.createStatement();
		String sql = "select * from temperature where name='"+username+"'";
		rs = st.executeQuery(sql);
		if(rs.next()){ //查找成功
			out.print("用户名已存在");
		}else{
			out.print("OK");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	finally{
		if(rs!=null) {try{rs.close();}catch(Exception e){} }
		if(st!=null) {try{st.close();}catch(Exception e){} }
		if(con!=null) {try{con.close();}catch(Exception e){}}
	}
%>