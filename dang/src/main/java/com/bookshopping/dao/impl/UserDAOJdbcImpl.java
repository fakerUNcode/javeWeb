package com.bookshopping.dao.impl;

import java.sql.ResultSet;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bookshopping.dao.UserDAO;
import com.bookshopping.entity.User;

@Repository("userDAO")  
public class UserDAOJdbcImpl implements UserDAO{	
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate template;
	
	public User findByEmail(String email) {
		//1.
		String sql = "select * from user where email= ?";
		//2.
		Object[] params = new Object[]{email};
		//3.ִ
		try{
			return template.queryForObject(sql, params ,new UserRowMapper());
		}catch(Exception e){
			return null;
		}
	}
	
	private class UserRowMapper implements RowMapper<User>{
		//4.
		public User mapRow(ResultSet rs, int index) 
				throws SQLException {
			User u = new User();
			u.setId(rs.getInt("id"));
			u.setEmail(rs.getString("email"));
			u.setNickname (rs.getString("nickname"));
			u.setPassword(rs.getString("password"));
			return u;
		}
	}

	public void save(User user) {
		//1.
		String sql = "insert into user values(null,?,?,?)";
		
		//2.
		Object[] params = new Object[]{
				user.getEmail(), 
				user.getNickname(),
				user.getPassword()
		};
		
		
		//3.
		template.update(sql,params);
	}

	public User findById(String id) {
		//1.
		String sql = "select * from user where id= ?";
		//2.
		Object[] params = new Object[]{id};
		//3.ִ
		return template.queryForObject(sql, params ,new UserRowMapper());
	}

	public int updateUser(User user) {
		//1.
		String sql = "update user set password=? where id=?";
		//2.
		Object[] params = new Object[]{
				user.getPassword(), user.getId()
		};
		//3.
		return template.update(sql,params);
	}
	
	
}

