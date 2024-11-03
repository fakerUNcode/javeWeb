package springjdbc;

import java.sql.SQLException;


import java.util.Date;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jdbc.bean.Report;
import com.jdbc.dao.ReportDAO;

public class TestCase {
	
	@Test
	public void test1() throws SQLException{
		ApplicationContext ac = new ClassPathXmlApplicationContext("springmvc.xml");
		DataSource ds = ac.getBean("ds", DataSource.class);
		System.out.println(ds.getConnection());
		JdbcTemplate template = ac.getBean("jdbcTemplate", JdbcTemplate.class);
		System.out.println(template);
	}

	@Test
	public void testDelete(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("springmvc.xml");
		ReportDAO dao = ac.getBean("reportDAOImpl", ReportDAO.class);
		dao.delete(1);
	}
	
	@Test
	public void testSave(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("springmvc.xml");
		ReportDAO dao = ac.getBean("reportDAOImpl", ReportDAO.class);
		Report r = new Report("ФЊзг","18976548521",false, new Date(), 36.3);
		dao.save(r);
	}
	
	@Test
	public void testFindById(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("springmvc.xml");
		ReportDAO dao = ac.getBean("reportDAOImpl", ReportDAO.class);
		System.out.println(dao.findById(2));
	}
	
	@Test
	public void testFindAll(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("springmvc.xml");
		ReportDAO dao = ac.getBean("reportDAOImpl", ReportDAO.class);
		System.out.println(dao.findAll());
	}
	
	@Test
	public void testFind(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("springmvc.xml");
		ReportDAO dao = ac.getBean("reportDAOImpl", ReportDAO.class);
		System.out.println(dao.find(1,2));
	}
	
	@Test
	public void testUpdate(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("springmvc.xml");
		ReportDAO dao = ac.getBean("reportDAOImpl", ReportDAO.class);
		Report r = new Report("ФЊзг","18976548521",true, new Date(), 38);
		dao.update(r);
	}
}
