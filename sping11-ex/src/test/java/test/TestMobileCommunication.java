package test;

import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.ContactPerson;
import bean.MobileCommunication;

public class TestMobileCommunication {
	@Test
	public void test(){		
		String conf = "/conf/springmvc.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		MobileCommunication mc = ac.getBean("mc",bean.MobileCommunication.class);
		
		Map<String,Set<ContactPerson>> map = mc.groupByGroup();
		mc.printGroup(map);
	}
		
}
