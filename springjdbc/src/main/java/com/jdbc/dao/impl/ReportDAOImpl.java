package com.jdbc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jdbc.bean.Report;


@Repository("reportDAOImpl") 
public class ReportDAOImpl implements com.jdbc.dao.ReportDAO{
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate template;

	
	public void delete(int id) {
		//1.����SQL���
		String sql = "delete from temperature where id = ?";
		//2.׼������:ֻ��id
		//3.ִ��SQL���
		template.update(sql, id);		
	}
	
	public void save(Report report) {	
		//1.����SQL���
		String sql = "insert into temperature values(null,?,?,?,?,?)";
		
		//2.׼������
		Object[] params = new Object[]{
				report.getName(), report.getTelephone(),
				report.isContacted(), report.getDate(),
				report.getTemp()
		};
		
		//3.ִ��SQL���
		template.update(sql,params);
	}
	
	public void update(Report report) {
		//1.����SQL���
		String sql = "update temperature set isContacted=?, temp=?";
		
		//2.׼������
		Object[] params = new Object[]{
				report.isContacted(), report.getTemp()
		};
		
		//3.ִ��SQL���
		template.update(sql,params);
		
	}

	public Report findById(int id) {
		//1.����SQL���
		String sql = "select * from temperature where id= ?";
		//2.׼������
		Object[] params = new Object[]{id};
		//3.ִ��SQL���
//		return template.queryForObject(sql, params ,new RowMapper<Report>(){
//			//4.ʵ�ֽӿڷ���
//			public Report mapRow(ResultSet rs, int index) 
//					throws SQLException {
//				Report r = new Report();
//				r.setId(rs.getInt("id"));
//				r.setName(rs.getString("name"));
//				r.setTelephone(rs.getString("telephone"));
//				r.setContacted(rs.getInt("isContacted")==0?false:true);
//				r.setDate(rs.getDate("date"));
//				r.setTemp(rs.getDouble("temp"));
//				return r;
//			}
//		});	
		return template.queryForObject(sql, params ,new ReportRowMapper());
	}

	public List<Report> findAll() {
		//1.����SQL���
		String sql = "select * from temperature";
		//2.׼����������
		//3.ִ��SQL���
		return template.query(sql, new ReportRowMapper()) ;	
	}


	private class ReportRowMapper implements RowMapper<Report>{
		//4.ʵ�ֽӿڷ���
		public Report mapRow(ResultSet rs, int index) 
				throws SQLException {
			Report r = new Report();
			r.setId(rs.getInt("id"));
			r.setName(rs.getString("name"));
			r.setTelephone(rs.getString("telephone"));
			r.setContacted(rs.getInt("isContacted")==0?false:true);
			r.setDate(rs.getDate("date"));
			r.setTemp(rs.getDouble("temp"));
			return r;
		}
	}


	public List<Report> find(int begin, int end) {
		//1.����SQL���
		String sql = "select * from temperature limit ?,?";
		//2.׼������
		Object[] params = new Object[]{begin, end};
		//3.ִ��SQL���
		return template.query(sql, params, new ReportRowMapper()) ;	
	}
	
}
