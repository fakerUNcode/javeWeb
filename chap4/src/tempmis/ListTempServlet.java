package tempmis;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
		RequestDispatcher patcher = request.getRequestDispatcher("");
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
			   
			List<TempReport> list = new ArrayList<TempReport>();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String tele = rs.getString("telephone");
				int isContacted = rs.getInt("isContacted");
				Date date = rs.getDate("date");
				double temperature = rs.getFloat("temp");
				
				TempReport t = new TempReport(id,name,tele,isContacted, date, temperature);
				list.add(t);
			}
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("showlist.jsp").forward(request, response);			

		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(con!=null) {try{con.close();}catch(Exception e){}}
		}
	}
	

}
