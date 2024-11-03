package bean;

import java.io.Serializable;

public class Student implements Serializable{
	private String name;
	private int grade;
	private Course[] courses;     //学生选择的多门课程

	public Student() {
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(String name, int grade, Course[] courses) {
		super();
		this.name = name;
		this.grade = grade;
		this.courses = courses;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Course[] getCourses() {
		return courses;
	}

	public void setCourses(Course[] courses) {
		this.courses = courses;
	}

	public int getHours(){
		int sum=0;
		for(int i=0; i<courses.length; i++){
			sum+= courses[i].getCreditHour();
		}
		return sum;
	}
	
	public void show(){
		System.out.println(name+" "+ grade+"年级 ");
		
		System.out.println("选修的课程包括：");
		for(int i=0; i<courses.length; i++){
			System.out.println("("+(i+1)+"}"+courses[i].getCourseName()+ "\t" + courses[i].getCreditHour()+"分");			
		}
		System.out.println("总学分:"+getHours());
		
	}
}
