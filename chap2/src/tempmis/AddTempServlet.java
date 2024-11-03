package tempmis;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddTempServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		//1.获取表单提交的数据
		request.setCharacterEncoding("UTF-8");	
		String name = request.getParameter("name");
		String telephone = request.getParameter("telephone");
		String isContacted = request.getParameter("isContacted");
		String temperature = request.getParameter("temperature");
		
		int isCon = 0;
		if(isContacted!=null){
			Integer.parseInt(isContacted);
		}
		double temp=0;
		if(temperature!=null){
			temp= Double.parseDouble(temperature);
		}
		
		//2.将数据持久化到数据库
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con =  DriverManager.getConnection(
	                "jdbc:mysql://127.0.0.1:3306/temp?characterEncoding=utf8",
	                "root", "1234");
			String sql = "insert into temperature(name,telephone,isContacted,date,temp) values(?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2,telephone);
			pst.setInt(3, isCon);
			pst.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
			pst.setDouble(5,temp);			
			pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(rs!=null) {try{rs.close();} catch(Exception e){}}
			if(pst!=null) {try{pst.close();} catch(Exception e){}}
			if(con!=null) {try{con.close();} catch(Exception e){}}
		}	
		
		//3.重定向到查询页面
		response.sendRedirect("findall");
	}	
}
