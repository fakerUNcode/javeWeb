package bean;

public class Course {
	private String  cname;
	private int creditHour;
	
	public Course() {
	}
	public Course(String cname, int creditHour) {
		this.cname = cname;
		this.creditHour = creditHour;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCreditHour() {
		return creditHour;
	}
	public void setCreditHour(int creditHour) {
		this.creditHour = creditHour;
	}
}
