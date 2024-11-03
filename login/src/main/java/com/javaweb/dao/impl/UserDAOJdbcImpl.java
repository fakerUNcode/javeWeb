package com.javaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.javaweb.bean.User;
import com.javaweb.dao.UserDAO;


@Repository("userDAO")  //标识持久层的Bean对象
public class UserDAOJdbcImpl implements UserDAO{	
	
	@Resource(name="ds")    //按名字注入Spring容器中的Bean对象
	private DataSource ds;

	public User findByName(String username) {
		if(username==null){
			return null;
		}
		Connection con = null;
		
		try {
			con = ds.getConnection();
			
			String sql = "select * from user_info where name= ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String pwd = rs.getString("password");
				User u = new User(id, name, pwd);
				return u;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
