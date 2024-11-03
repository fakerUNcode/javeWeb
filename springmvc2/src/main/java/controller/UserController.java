package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/add.do")
	public String addUser(){
		return null;
	}
	@RequestMapping("/delete.do")
	public String deleteUser(){
		return null;
	}
	@RequestMapping("/modify.do")
	public String modifyUser(){
		return null;
	}
}
