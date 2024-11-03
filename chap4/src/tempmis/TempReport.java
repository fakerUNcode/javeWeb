package tempmis;

import java.util.Date;

public class TempReport {
	private int id;
	private String name;
	private String telephone;
	private int isContacted;
	private Date date;
	private double temp;
	
	public TempReport() {
		super();
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getIsContacted() {
		return isContacted;
	}

	public void setIsContacted(int isContacted) {
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

	public TempReport(int id, String name, String telephone, int isContacted, Date date, double temp) {
		super();
		this.id = id;
		this.name = name;
		this.telephone = telephone;
		this.isContacted = isContacted;
		this.date = date;
		this.temp = temp;
	}
	
	

}
