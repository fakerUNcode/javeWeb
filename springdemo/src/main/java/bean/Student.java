package bean;

import java.io.Serializable;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Student implements Serializable{
	private String name;
	private int age;
	private MobilePhone phone;
	
    private Set<String> hobbies;
    private Map<String, Object> scores;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(Set<String> hobbies) {
		this.hobbies = hobbies;
	}
	public Map<String, Object> getScores() {
		return scores;
	}
	public void setScores(Map<String, Object> scores) {
		this.scores = scores;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public MobilePhone getPhone() {
		return phone;
	}
	public void setPhone(MobilePhone phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", phone=" + phone + ", hobbies=" + hobbies + ", scores="
				+ scores + "]";
	}
}
