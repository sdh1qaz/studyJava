package freemarker的使用;

import java.io.Serializable;

import javax.print.DocFlavor.STRING;

/**
 * 返还记录
 */

public class ReturnRecords implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8112175639735774362L;
	private String monRetValue;//返还金额
	private String monRetDate;//返还日期
	
	public String getMonRetValue() {
		return monRetValue;
	}
	public void setMonRetValue(String monRetValue) {
		this.monRetValue = monRetValue;
	}
	public String getMonRetDate() {
		return monRetDate;
	}
	public void setMonRetDate(String monRetDate) {
		this.monRetDate = monRetDate;
	}
	
	@Override
	public String toString() {
		return "ReturnRecords [monRetValue=" + monRetValue + ", monRetDate=" + monRetDate + "]";
	}

}
