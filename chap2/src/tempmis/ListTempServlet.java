package tempmis;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ListTempServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con =  DriverManager.getConnection(
	                "jdbc:mysql://127.0.0.1:3306/temp?useUnicode=true&characterEncoding=utf8",
	                "root", "1234");
			st = con.createStatement();
			String sql = "select * from temperature";
			rs = st.executeQuery(sql);
			   
			out.print("<table border='1px' cellpadding='10' cellspacing='0'>");
			out.print("<tr>");
			out.print("<th>序号</th>");
			out.print("<th>姓名</th>");
			out.print("<th>电话</th>");
			out.print("<th>14天内是否有湖北接触史</th>");
			out.print("<th>日期</th>");
			out.print("<th>体温</th>");
			out.print("</tr>");
			
//			rs.getInt("id")
//			rs.getString("name")
//			rs.getString("telephone")
//			rs.getInt("isContacted")
//			rs.getDate("date")
//			rs.getFloat("temp")
			
			
			//数据部分
			while(rs.next()){
				out.print("<tr>");
				out.print("<td>"+ rs.getInt("id") +"</td>");
				out.print("<td>"+rs.getString("name")+"</td>");
				out.print("<td>"+rs.getString("telephone")+"</td>");
				if(rs.getInt("isContacted")==0){
					out.print("<td style='text-align:center'> 否 </td>");
				}else{
					out.print("<td style='text-align:center'> 是 </td>");
				}
				out.print("<td>"+rs.getDate("date")+"</td>");
				out.print("<td>"+rs.getFloat("temp")+"</td>");
				out.print("</tr>");			
			}
			out.print("</table><br/>");
			
			out.print("<input type='button' value='  添加新数据  ' "
					+ "onclick='location.href=\"tmp/addTemp.html\"' />");

		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(rs!=null) {try{rs.close();} catch(Exception e){}}
			if(st!=null) {try{st.close();} catch(Exception e){}}
			if(con!=null) {try{con.close();} catch(Exception e){}}
		}
	}
}
