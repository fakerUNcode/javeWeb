package util;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBUtil {
	private static BasicDataSource dataSource;

	static {
		Properties propConfig = new Properties();
		try {
			//1.加载配置文件
			InputStream in = DBUtil.class.
					getClassLoader().
					getResourceAsStream("jdbc.properties");
			propConfig.load(in);		
						
			//2.读取初始化参数
			String driver = propConfig.getProperty("driver");
			String url = propConfig.getProperty("url");
			String username = propConfig.getProperty("username");
			String password = propConfig.getProperty("password");
			int initSize = Integer.parseInt(propConfig.getProperty("initialSize"));
			int maxTotal = Integer.parseInt(propConfig.getProperty("maxTotal"));
			int maxIdle = Integer.parseInt(propConfig.getProperty("maxIdle"));
			int minIdle = Integer.parseInt(propConfig.getProperty("minIdle"));
			int maxWait = Integer.parseInt(propConfig.getProperty("maxWait"));
			in.close();
			
			//3.创建连接池对象
			dataSource = new BasicDataSource();
			
			//4.初始化连接池
			dataSource.setDriverClassName(driver);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			dataSource.setInitialSize(initSize);
			dataSource.setMaxTotal(maxTotal);	
			dataSource.setMaxIdle(maxIdle);
			dataSource.setMinIdle(minIdle);
			dataSource.setMaxWaitMillis(maxWait);
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("初始化连接池失败！");
			
		}
	}
	
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(getConnection());
//		closeConnection(getConnection());
	}

}
