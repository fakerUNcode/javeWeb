package bean;

public class Report {
	private String name;
	private String telephone;
	private boolean isContacted;
	private double temperature;
	
	public Report() {
		super();
	}
	public Report(String name, String telephone, boolean isContacted, double temperature) {
		super();
		this.name = name;
		this.telephone = telephone;
		this.isContacted = isContacted;
		this.temperature = temperature;
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
	public boolean getIsContacted() {
		return isContacted;
	}
	public void setContacted(boolean isContacted) {
		this.isContacted = isContacted;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
	@Override
	public String toString() {
		return "Report [name=" + name + ", telephone=" + telephone + ", "
				+ "isContacted=" + isContacted + ", temperature="
				+ temperature + "]";
	}
	
}
