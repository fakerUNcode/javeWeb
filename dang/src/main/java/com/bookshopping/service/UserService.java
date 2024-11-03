package com.bookshopping.service;

import com.bookshopping.entity.User;
import com.bookshopping.exception.ExistedEmailException;
import com.bookshopping.exception.PasswordException;
import com.bookshopping.exception.UserNameException;

public interface UserService {
	
	public User checkEmail(String email) throws ExistedEmailException;

	public User checkLogin(String email, String password)
			throws UserNameException,PasswordException;

	public void addUser(String email, String password, String nickname);

}
