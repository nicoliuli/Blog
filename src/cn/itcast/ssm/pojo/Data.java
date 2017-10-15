package cn.itcast.ssm.pojo;

import java.math.BigDecimal;

public class Data {
	public  double hasUpload;
	public  double total;
	public  int item;
	public double present;
	public static String Message;
	
	public double getHasUpload() {
		return hasUpload;
	}
	public void setHasUpload(double hasUpload) {
		this.hasUpload = hasUpload;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}
	public double getPresent() {
		return present;
	}
	public void setPresent(double present) {
		BigDecimal b = new BigDecimal(present);
		
		this.present = b.divide(new BigDecimal(1),3, BigDecimal.ROUND_HALF_UP).doubleValue()*100;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}	
}
