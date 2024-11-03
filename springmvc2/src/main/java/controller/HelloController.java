package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.Report;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello.do")
	public String hello(){
		return "hello";
	}

}
