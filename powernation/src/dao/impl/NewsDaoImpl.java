package dao.impl;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.NewsDao;
import entity.News;
import util.DBUtil;

public class NewsDaoImpl implements NewsDao{

	public List<News> findAll() {
		Connection con =null;
		Statement st = null;
		ResultSet rs = null;
		
		try {			
			//1.从数据库连接池获取一个连接
			con = DBUtil.getConnection();
			//2.获取Statement对象
			st = con.createStatement();
			String sql = "select * from news";			
			rs = st.executeQuery(sql);
			
			//3.处理查询结果
			List<News> list = new ArrayList<News>();
			while(rs.next()){
				News news = new News();
				
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setDate(rs.getDate("date"));			
				if(rs.getInt("isreleased")==1){
					news.setReleased(true);
				}else{
					news.setReleased(false);
				}
				list.add(news);
			}		
			return list;
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=null)  {try{rs.close();} catch(Exception e){}}
			if(st!=null)  {try{st.close();} catch(Exception e){}}
			if(con!=null) {try{con.close();} catch(Exception e){}}
		}
		return null;
	}
}
