package com.bookshopping.entity;

import java.io.Serializable;

public class User implements Serializable{
	private int id;
	private String email;
	private String nickname;
	private String password;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String email, String nickname, String password) {
		super();
		this.email = email;
		this.nickname = nickname;
		this.password = password;
	}
	public User() {
		super();
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email +
				", nickname=" + nickname + ", password=" + password + "]";
	}
}
