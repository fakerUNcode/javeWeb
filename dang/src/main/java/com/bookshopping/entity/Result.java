package com.bookshopping.entity;

import java.io.Serializable;

public class Result implements Serializable{
	private int status;  // 状态标志
	private String msg;  // 信息
	
	public Result(int status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}
	public Result() {
		super();
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
