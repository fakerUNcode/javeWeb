package com.bookshopping.dao;

import com.bookshopping.entity.User;

public interface UserDAO {
	
	public User findByEmail(String email);

	public void save(User user);

	public User findById(String id);

	public int updateUser(User user);

}
