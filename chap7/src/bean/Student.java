package bean;

import java.io.Serializable;

public class Student implements Serializable{
	private String name;
	private int grade;
	private Course[] courses;     //ѧ��ѡ��Ķ��ſγ�

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
		System.out.println(name+" "+ grade+"�꼶 ");
		
		System.out.println("ѡ�޵Ŀγ̰�����");
		for(int i=0; i<courses.length; i++){
			System.out.println("("+(i+1)+"}"+courses[i].getCourseName()+ "\t" + courses[i].getCreditHour()+"��");			
		}
		System.out.println("��ѧ��:"+getHours());
		
	}
}
