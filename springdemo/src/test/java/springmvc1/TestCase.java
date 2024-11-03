package springmvc1;

import java.util.ArrayList;


import java.util.Properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import util.DBUtil;
import bean.DIYComputer;
import bean.ExampleBean;
import bean.MobilePhone;
import bean.Student;

public class TestCase {
	/**
	 * 容器实例化测试
	 */
	@Test
	public void test1() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		System.out.println(ac);
	}

	/**
	 * Bean实例化测试
	 */
	@Test
	public void test2() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		ExampleBean ex = ac.getBean("example", bean.ExampleBean.class);
		// ExampleBean ex = (ExampleBean)ac.getBean("example");
	}

	/**
	 * setter注入
	 */
	@Test
	public void test3() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		DIYComputer computer = ac.getBean("computer", DIYComputer.class);
		System.out.println(computer.getMainboard());
		System.out.println(computer.getCpu());
		System.out.println(computer.getRam());
	}

	/**
	 * 构造器注入
	 */
	@Test
	public void test4() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		MobilePhone phone = ac.getBean("phone", MobilePhone.class);
		System.out.println(phone.getCpu());
		System.out.println(phone.getRam());
	}
	
	/**
	 * Bean对象注入
	 */
	@Test
	public void test5() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		Student stu = ac.getBean("stu", Student.class);
		System.out.println(stu.getName());
		System.out.println(stu.getAge());
		System.out.println(stu.getPhone().getCpu());
		System.out.println(stu.getPhone().getRam());
	}
	
	/**
	 * 集合注入
	 */
	@Test
	public void test6() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		Student stu = ac.getBean("stu2", Student.class);
		System.out.println(stu);
	}

	/**
	 * 集合注入--Map中为对象类型
	 */
	@Test
	public void test7() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		Student stu = ac.getBean("stu3", Student.class);
		System.out.println(stu);
	}
	
	/**
	 * 集合注入--Map中为对象类型
	 */
	@Test
	public void test8() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		Student stu = ac.getBean("stu4", Student.class);
		System.out.println(stu);
	}
	//list-class="java.util.ArrayList"
	
	/**
	 * 配置文件注入
	 */
	@Test
	public void test9() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		ArrayList list = ac.getBean("mylist", ArrayList.class);
		System.out.println(list);
	}
	
	/**
	 * 配置文件注入
	 */
	@Test
	public void test10() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		Properties config = ac.getBean("jdbc", Properties.class);
		System.out.println(config);
	}
	
	/**
	 * Spring表达式注入
	 */
	@Test
	public void test11() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		DBUtil ds = ac.getBean("ds", DBUtil.class);
		System.out.println(ds.getConnection());
	}
	
	@Test
	public void test12(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		MobilePhone phone1 = ac.getBean("phone", MobilePhone.class);
		MobilePhone phone2 = ac.getBean("phone", MobilePhone.class);
		System.out.println(phone1==phone2);
	}
}
