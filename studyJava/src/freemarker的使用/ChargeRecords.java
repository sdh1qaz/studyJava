package freemarker的使用;

import java.io.Serializable;

/**
 * 充值记录
 */

public class ChargeRecords implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8613741717964623052L;
	private String chargeSum;//充值钱数
	private String effDate;//充值钱数
	
	public String getChargeSum() {
		return chargeSum;
	}
	public void setChargeSum(String chargeSum) {
		this.chargeSum = chargeSum;
	}
	public String getEffDate() {
		return effDate;
	}
	public void setEffDate(String effDate) {
		this.effDate = effDate;
	}

}
