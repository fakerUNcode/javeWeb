package bean;

import java.io.Serializable;

public class Course  implements Serializable{
	private String courseName;  //课程名
	public Course(String courseName, int creditHour) {
		super();
		this.courseName = courseName;
		this.creditHour = creditHour;
	}
	private int creditHour; //学分
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCreditHour() {
		return creditHour;
	}
	public void setCreditHour(int creditHour) {
		this.creditHour = creditHour;
	}

	


}
