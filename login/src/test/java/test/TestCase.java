package test;

import java.sql.SQLException;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javaweb.bean.User;
import com.javaweb.dao.UserDAO;
import com.javaweb.exception.PasswordException;
import com.javaweb.exception.UserNameException;
import com.javaweb.service.LoginService;

public class TestCase {
	ApplicationContext ac;
	
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("springmvc.xml");
	}
	
//	@Test
//	public void test1() throws SQLException{
//		DataSource ds = ac.getBean("ds", DataSource.class);
//		System.out.println(ds.getConnection());
//	}
	
//	@Test
//	public void test2(){
//		UserDAO dao = ac.getBean("userDAO", UserDAO.class);
//		User u = dao.findByName("admin");
//		System.out.println(u.getId());
//	}
//	
	@Test
	public void test3(){
		LoginService service = ac.getBean("loginService",LoginService.class);
		try {
			User u = service.checkLogin("admin","123456");
			System.out.println(u.getId());
		} catch (UserNameException e) {
			System.out.println(e.getMessage());
		} catch (PasswordException e) {
			System.out.println(e.getMessage());
		}
	}

}
