package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.ShowMessage;

public class TestConst {
	
	@Test
	public void test(){
		ApplicationContext ac = new 
				ClassPathXmlApplicationContext("conf/springmvc.xml");
		ShowMessage show =  ac.getBean("showMessage", ShowMessage.class);
		System.out.println(show.getPageSize());
	}

}
