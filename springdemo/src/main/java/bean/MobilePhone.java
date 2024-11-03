package bean;

import java.io.Serializable;

public class MobilePhone implements Serializable {
	private String cpu;
	private String ram;

	public MobilePhone() {
	}

	public MobilePhone(String cpu, String ram) {
		this.cpu = cpu;
		this.ram = ram;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}
}
