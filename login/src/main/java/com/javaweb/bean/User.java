package com.javaweb.bean;

import java.io.Serializable;

public class User implements Serializable{
	private int id;
	private String name;
	private String pwd;
	private String telephone;
	private String email;
	public User() {
		super();
	}
	
	public User(int id, String name, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}

	public User(String name, String pwd, String telephone, String email) {
		this.name = name;
		this.pwd = pwd;
		this.telephone = telephone;
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + 
				", telephone=" + telephone + ", email=" + email
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
