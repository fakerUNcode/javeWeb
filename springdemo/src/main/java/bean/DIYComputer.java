package bean;

import java.io.Serializable;

public class DIYComputer implements Serializable{
	private String mainboard; // ����
    private String cpu; // CPU
    private String ram; // �ڴ�
    
    public void setMainboard(String mainboard) {
        this.mainboard = mainboard;
    }
    public String getMainboard() {
		return mainboard;
	}
   	public void setRam(String ram) {
        this.ram = ram;
    }
    public String getRam() {
        return ram;
    }
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
    
}
