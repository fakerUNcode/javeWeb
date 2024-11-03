package com.javaweb.dao;

import com.javaweb.bean.User;

public interface UserDAO {
	User findByName(String username);

}
