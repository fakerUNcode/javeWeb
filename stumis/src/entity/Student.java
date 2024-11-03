package entity;

import java.io.Serializable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements Serializable{ //序列化接口
	private Integer id;   //NULL
	private String name;
	private String sex;
	private Date birthday;  //java.util.Date
	private String mobilephone;
	private String email;
	
	//set+get方法
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getMobilephone() {
		return mobilephone;
	}
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//构造方法
	public Student() {
		super();
	}
	
	public Student(Integer id, String name, String sex, Date birthday,
			String mobilephone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.mobilephone = mobilephone;
		this.email = email;
	}
	
	public Student(String name, String sex, Date birthday,
			String mobilephone, String email) {
		super();
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.mobilephone = mobilephone;
		this.email = email;
	}
	
	public String toString(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return "id="+id+",name="+name+",sex="+sex+",birthday="+sdf.format(birthday)+",mobilephone="+mobilephone+",email="+email;
	}
}
