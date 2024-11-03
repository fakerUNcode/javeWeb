<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="GBK"%>
<%@ page import="java.sql.*" %>
<%@ page import="net.sf.json.JSONObject" %>
<%@ page import="entity.Result" %>


<%
	Result r = new Result();
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
			r.setStatus(0);
			r.setMsg("用户名已存在");
		}else{
			r.setStatus(1);
			r.setMsg("用户名可用");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	finally{
		if(rs!=null) {try{rs.close();}catch(Exception e){} }
		if(st!=null) {try{st.close();}catch(Exception e){} }
		if(con!=null) {try{con.close();}catch(Exception e){}}
	}
	JSONObject  jsonObj =JSONObject.fromObject(r);
	out.print(jsonObj.toString());
%>