package com.javaweb.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.javaweb.bean.User;
import com.javaweb.dao.UserDAO;
import com.javaweb.exception.PasswordException;
import com.javaweb.exception.UserNameException;
import com.javaweb.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Resource(name = "userDAO")
	private UserDAO dao;

	public User checkLogin(String name, String pwd) 
			throws UserNameException, PasswordException {
		User user = dao.findByName(name);
		if (user == null) {
			throw new UserNameException("无此用户");
		} else if (!user.getPwd().equals(pwd)) {
			throw new PasswordException("密码错误");
		}
		return user;
	}
}
