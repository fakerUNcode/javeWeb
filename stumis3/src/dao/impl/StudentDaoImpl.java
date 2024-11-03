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

import dao.StudentDao;
import entity.Student;
import util.DBUtil;

public class StudentDaoImpl implements StudentDao{

	public List<Student> findAll() {
		Connection con =null;
		Statement st = null;
		ResultSet rs = null;
		
		try {			
			//1.从数据库连接池获取一个连接
			con = DBUtil.getConnection();
			//2.获取Statement对象
			st = con.createStatement();
			String sql = "select * from student";			
			rs = st.executeQuery(sql);
			
			//3.处理查询结果
			List<Student> list = new ArrayList<Student>();
			while(rs.next()){
				Student stu = new Student();
				
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setSex(rs.getString("sex"));				
				stu.setBirthday(rs.getDate("birthday"));				
				stu.setMobilephone(rs.getString("mobilephone"));
				stu.setEmail(rs.getString("email"));				
				list.add(stu);
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

	
	public void save(Student stu) {		
		Connection con =null;
		PreparedStatement pst = null;
		
		try {
			//1.从数据库连接池获取一个连接
			con = DBUtil.getConnection();
			
			String sql = "insert into student(name,sex,birthday,mobilephone,email) " +
					"values(?,?,?,?,?)";
			pst = con.prepareStatement(sql);			
			pst.setString(1, stu.getName());
			pst.setString(2, stu.getSex());
			pst.setDate(3, new java.sql.Date(stu.getBirthday().getTime()));
			pst.setString(4,stu.getMobilephone());
			pst.setString(5,stu.getEmail());
			pst.executeUpdate();
		}catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			if(pst!=null)  {try{pst.close();} catch(Exception e){}}
			if(con!=null) {try{con.close();} catch(Exception e){}}
		}	
	}

	public Student findById(int id) {
		Connection con =null;
		PreparedStatement pst =null;

		try {
			//1.从数据库连接池获取一个连接
			con = DBUtil.getConnection();
			
			String sql="select * from student where id=?";
			pst = con.prepareStatement(sql);			
			pst.setInt(1, id);				
			ResultSet rs = pst.executeQuery();

			if(rs.next()){
				Student stu = new Student();				
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setSex(rs.getString("sex"));				
				stu.setBirthday(rs.getDate("birthday"));				
				stu.setMobilephone(rs.getString("mobilephone"));
				stu.setEmail(rs.getString("email"));
				return stu;
			}			
		}catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			if(pst!=null)  {try{pst.close();} catch(Exception e){}}
			if(con!=null) {try{con.close();} catch(Exception e){}}
		}		
		return null;
	}
	
	public void update(int id, Student stu) {		
		Connection con =null;
		PreparedStatement pst =null;

		try {
			//1.从数据库连接池获取一个连接
			con = DBUtil.getConnection();
			
			String sql="update student set name=? , sex=?, birthday=?, mobilephone=?, email=? where id=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, stu.getName());
			pst.setString(2, stu.getSex());
			pst.setDate(3, new java.sql.Date(stu.getBirthday().getTime()));  //java.util->java.sql
			pst.setString(4, stu.getMobilephone());
			pst.setString(5, stu.getEmail());
			pst.setInt(6, id);			
			pst.executeUpdate();
		}catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			if(pst!=null)  {try{pst.close();} catch(Exception e){}}
			if(con!=null) {try{con.close();} catch(Exception e){}}
		}	
	}

	public void delete(int id) {
		Connection con =null;
		PreparedStatement pst =null;
		
		//插入时使用带参数的SQL语句  ---PreparedStatement
		String sql="delete from student where id=?";
		
		try {
			//1.从数据库连接池获取一个连接
			con = DBUtil.getConnection();
			
			pst = con.prepareStatement(sql);			
			pst.setInt(1, id);				
			pst.executeUpdate();
		}catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			if(pst!=null)  {try{pst.close();} catch(Exception e){}}
			if(con!=null) {try{con.close();} catch(Exception e){}}
		}	
	}

	public int findByMobilephone(String mobilephone) {
		Connection con =null;
		PreparedStatement pst =null;
		
		//插入时使用带参数的SQL语句  ---PreparedStatement
		String sql="select id from student where mobilephone=?";
		
		try {
			//1.从数据库连接池获取一个连接
			con = DBUtil.getConnection();
			
			pst = con.prepareStatement(sql);			
			pst.setString(1, mobilephone);				
			ResultSet rs = pst.executeQuery();
			
			//一条
			if(rs.next()){
				return rs.getInt("id");
			}			
		}catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			if(pst!=null)  {try{pst.close();} catch(Exception e){}}
			if(con!=null) {try{con.close();} catch(Exception e){}}
		}		
		return 0;
	}


	@Override
	public List findByMultiCondition(String id, String name, String mobilephone, String sex) {
		boolean flag=false;
		String sql = "select * from student ";
		if(id!=null && id.length()!=0){
			sql += "where id =" + id;
			flag=true;
		}
		if(name!=null && name.length()!=0 ){
			if(flag){
				sql += " and name like'"+name+"%'";
			}else{
				sql += " where name like '"+name+"%'";
				flag=true;
			}
		}
		if(mobilephone!=null && mobilephone.length()!=0){
			if(flag){
				sql += " and mobilephone like '"+mobilephone+"%'";
			}else{
				sql += " where mobilephone like '"+mobilephone+"%'";
				flag=true;
			}
		}
		if(sex!=null && sex.length()!=0){
			if(!sex.equals("all")){
				if(sex.equals("male")){
					sex="男";
				}else if(sex.equals("female")){
					sex="女";
				} 
				if(flag){
					sql += " and sex='"+sex+"'";
				}else{
					sql += " where sex='"+sex+"'";
				}
			}
		}
		
		System.out.println(sql);
		
		Connection con =null;
		Statement st =null;
		
		try {
			//1.从数据库连接池获取一个连接
			con = DBUtil.getConnection();
			
			st = con.createStatement();			
			ResultSet rs = st.executeQuery(sql);
			
			//3.处理查询结果
			List<Student> list = new ArrayList<Student>();
			while(rs.next()){
				Student stu = new Student();
				
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setSex(rs.getString("sex"));				
				stu.setBirthday(rs.getDate("birthday"));				
				stu.setMobilephone(rs.getString("mobilephone"));
				stu.setEmail(rs.getString("email"));				
				list.add(stu);
			}		
			return list;		
		}catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			if(st!=null)  {try{st.close();} catch(Exception e){}}
			if(con!=null) {try{con.close();} catch(Exception e){}}
		}		
		return null;
	}
	
	public List<Student> findByPage(int page, int pageSize) {
		Connection con =null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {			
			//1.从数据库连接池获取一个连接
			con = DBUtil.getConnection();
			
			String sql = "select * from student limit ?,?";
			
			//2.获取Statement对象
			pst = con.prepareStatement(sql);
			pst.setInt(1, (page-1)*pageSize);
			pst.setInt(2, pageSize);
			
			rs = pst.executeQuery();
			
			//3.处理查询结果
			List<Student> list = new ArrayList<Student>();
			while(rs.next()){
				Student stu = new Student();
				
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setSex(rs.getString("sex"));				
				stu.setBirthday(rs.getDate("birthday"));				
				stu.setMobilephone(rs.getString("mobilephone"));
				stu.setEmail(rs.getString("email"));				
				list.add(stu);
			}		
			return list;
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=null)  {try{rs.close();} catch(Exception e){}}
			if(pst!=null)  {try{pst.close();} catch(Exception e){}}
			if(con!=null) {try{con.close();} catch(Exception e){}}
		}
		return null;
	}
}
