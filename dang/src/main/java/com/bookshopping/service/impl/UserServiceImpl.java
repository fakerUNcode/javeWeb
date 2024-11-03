package com.bookshopping.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bookshopping.dao.UserDAO;
import com.bookshopping.entity.User;
import com.bookshopping.exception.ExistedEmailException;
import com.bookshopping.exception.PasswordException;
import com.bookshopping.exception.UserNameException;
import com.bookshopping.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource(name = "userDAO")
	private UserDAO dao;
	
	public User checkEmail(String email) throws ExistedEmailException { //查重		
		User user = dao.findByEmail(email);
		if (user != null) {
			throw new ExistedEmailException("existed");
		}
		return user;
	}
	
	public User checkLogin(String email, String password) 
			throws UserNameException, PasswordException {
		User user = dao.findByEmail(email);
		if (user == null) {
			throw new UserNameException("没有这个用户名");
		} else if (!user.getPassword().equals(password)) {
			throw new PasswordException("密码错");
		}
		return user;
	}

	public void addUser(String email, String password, String nickname) {
		User user=new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setNickname(nickname);
		dao.save(user);
	}

}
