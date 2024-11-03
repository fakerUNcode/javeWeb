package util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil implements Serializable{
	private String driverClassName;
	private String url;
	private String username;
	private String password;

	public DBUtil() {
	}
	public String getDriverClassName() {
		return driverClassName;
	}


	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getConnection(){
		Connection con = null;
		try {
			Class.forName(driverClassName);
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
