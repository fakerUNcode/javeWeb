package com.javaweb.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaweb.bean.User;
import com.javaweb.exception.PasswordException;
import com.javaweb.exception.UserNameException;
import com.javaweb.service.LoginService;

@Controller
public class LoginController {
	
	@Resource(name="loginService")
	private LoginService sevice;
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		return "main/login";
	}
	
	@RequestMapping("/checkLogin.do")
	public String login(String name, String pwd, 
			HttpSession session, ModelMap model){
		try {
			User u = sevice.checkLogin(name, pwd);
			session.setAttribute("username", name);
			return "redirect:toIndex.do";			
		} catch (UserNameException e) {
			model.addAttribute("message", e.getMessage());
			return "main/error";
		} catch (PasswordException e) {
			model.addAttribute("message", e.getMessage());
			return "main/error";
		}
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		return "main/index";
	}
}
