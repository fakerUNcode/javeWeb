package cal;

import java.text.DecimalFormat;

public class TriangleBean {
	private double a, b, c;
	
	public TriangleBean() {
		
	}
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double getC() {
		return c;
	}
	public void setC(double c) {
		this.c = c;
	}
	
	public String getArea(){  //业务方法
		if(a>0 && b>0 && c>0 && a+b>c && b+c>a && a+c>b){
			double s = (a + b + c) / 2;
			double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));			
			return new DecimalFormat("##0.00").format(area);
		}else{
			return "您输入的三边有误";
		}
	}
	
	
}
