package com.jdbc.bean;

import java.util.Date;

public class Report {
	private int id;
	private String name;
	private String telephone;
	private boolean isContacted;
	private Date date;
	private double temp;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public boolean isContacted() {
		return isContacted;
	}
	public void setContacted(boolean isContacted) {
		this.isContacted = isContacted;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	public Report() {
		super();
	}
	public Report(String name, String telephone, boolean isContacted, Date date, double temp) {
		super();
		this.name = name;
		this.telephone = telephone;
		this.isContacted = isContacted;
		this.date = date;
		this.temp = temp;
	}
	@Override
	public String toString() {
		return "Report [id=" + id + ", name=" + name + ", telephone=" + telephone + ", isContacted=" + isContacted
				+ ", date=" + date + ", temp=" + temp + "]";
	}
	
}
