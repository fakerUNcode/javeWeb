package com.javaweb.service;

import com.javaweb.bean.User;
import com.javaweb.exception.PasswordException;
import com.javaweb.exception.UserNameException;

public interface LoginService {
	User checkLogin(String name,String pwd)
			throws UserNameException,PasswordException;

}
