import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bookshopping.dao.CategoryDAO;
import com.bookshopping.dao.UserDAO;
import com.bookshopping.dao.impl.AddBookDAO;
import com.bookshopping.dao.impl.BookDAOImpl;
import com.bookshopping.entity.Book;
import com.bookshopping.entity.Category;
import com.bookshopping.util.VerifyCodeUtil;

public class TestCase {
	
	@Test
	public void test1() throws SQLException{
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("springmvc.xml");
		DataSource ds = ac.getBean("ds", DataSource.class);
		System.out.println(ds.getConnection());
		JdbcTemplate template = ac.getBean("jdbcTemplate", JdbcTemplate.class);
		System.out.println(template);
	}

	@Test
	public void test2() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("springmvc.xml");
		CategoryDAO dao = ac.getBean("categoryDAO", CategoryDAO.class);
		try {
			System.out.println(dao.findNameById(20));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void test4() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("springmvc.xml");
		CategoryDAO dao = ac.getBean("categoryDAO", CategoryDAO.class);
		try {
			System.out.println(dao.findByParentId(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void test5() throws SQLException {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("springmvc.xml");
		CategoryDAO dao = ac.getBean("categoryDAO", CategoryDAO.class);
		
		List<Category> list =  dao.findAll();
		Iterator<Category> it = list.iterator();
		while(it.hasNext()){
			Category c= (Category)it.next();
			System.out.println(c.getName());
			List<Category> childrenList = c.getChildrenListCates();
			Iterator<Category> cIt = childrenList.iterator();
			while(cIt.hasNext()){
				Category ccc= (Category)cIt.next();
				System.out.println("  "+ccc.getName());
			}
		}
	}
	
	@Test
	public void test3() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("springmvc.xml");
		UserDAO dao = ac.getBean("userDAO",UserDAO.class);
		System.out.println(dao);
		System.out.println(dao.findByEmail("songyan_beijing@126.com"));
		
	}
	
	@Test
	public void test6() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("springmvc.xml");
		BookDAOImpl dao = ac.getBean("bookDAO", BookDAOImpl.class);
		try {
			List<Book> list = dao.findHotNewBook(new java.sql.Date(new Date().getTime()-10000000), 4);
			for(Book book: list){
				System.out.println(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test66() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("springmvc.xml");
		BookDAOImpl dao = ac.getBean("bookDAO", BookDAOImpl.class);
		try {
			List<Book> list = dao.findRecommendBook(2);
			for(Book book: list){
				System.out.println(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test7() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("springmvc.xml");
		BookDAOImpl dao = ac.getBean("bookDAO", BookDAOImpl.class);
		try {
			List<Book> list = dao.findBooksByCatId(22);
			for(Book book: list){
				System.out.println(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test8() throws SQLException {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("springmvc.xml");
		CategoryDAO dao = ac.getBean("categoryDAO", CategoryDAO.class);
		
		List<Category> list = dao.findAll();
		Iterator<Category> it = list.iterator();
		while(it.hasNext()){
			Category c= (Category)it.next();
			System.out.println(c);
		}
	}
//	
	@Test
	public void test9() throws SQLException {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("springmvc.xml");
		BookDAOImpl dao = ac.getBean("bookDAO", BookDAOImpl.class);
		try {
			List<Book> list = dao.findPageBooksByCatId(6,2,3);
			for(Book book: list){
				System.out.println(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
