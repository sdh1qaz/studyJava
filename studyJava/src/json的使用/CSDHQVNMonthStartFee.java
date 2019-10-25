package json的使用;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 使用内部类接收多层json
 * 
 * @Date:Created in 2019年10月25日
 */

public class CSDHQVNMonthStartFee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1600490910139240269L;
	private String message;
	private String status;
	private Data data;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public class Data {
		private String transIdo;
		private String oprTime;
		private QryInfoRsp qryInfoRsp;

		public String getTransIdo() {
			return transIdo;
		}

		public void setTransIdo(String transIdo) {
			this.transIdo = transIdo;
		}

		public String getOprTime() {
			return oprTime;
		}

		public void setOprTime(String oprTime) {
			this.oprTime = oprTime;
		}

		public QryInfoRsp getQryInfoRsp() {
			return qryInfoRsp;
		}

		public void setQryInfoRsp(QryInfoRsp qryInfoRsp) {
			this.qryInfoRsp = qryInfoRsp;
		}

		public class QryInfoRsp {
			private String sumBaseFee;
			private String sumFuncFee;
			private String sumPackageFee;
			private List<Fee> feeList;

			public boolean isHasFeeRecordToday() {
				if (feeList.size() == 0) {
					return false;
				}
				for (Fee fee : feeList) {
					String date = fee.getDate().substring(0, 4);
					String dToday = new SimpleDateFormat("MMdd").format(new Date());
					if (dToday.equals(date)) {
						return true;
					}
				}
				return false;
			}
			public String getSumBaseFee() {
				return sumBaseFee;
			}

			public void setSumBaseFee(String sumBaseFee) {
				this.sumBaseFee = sumBaseFee;
			}

			public String getSumFuncFee() {
				return sumFuncFee;
			}

			public void setSumFuncFee(String sumFuncFee) {
				this.sumFuncFee = sumFuncFee;
			}

			public String getSumPackageFee() {
				return sumPackageFee;
			}

			public void setSumPackageFee(String sumPackageFee) {
				this.sumPackageFee = sumPackageFee;
			}

			public List<Fee> getFeeList() {
				return feeList;
			}

			public void setFeeList(List<Fee> feeList) {
				this.feeList = feeList;
			}

			public class Fee {
				private String feeAmount;
				private String feeType;
				private String feeName;
				private String date;

				public String getFeeAmount() {
					return feeAmount;
				}

				public void setFeeAmount(String feeAmount) {
					this.feeAmount = feeAmount;
				}

				public String getFeeType() {
					return feeType;
				}

				public void setFeeType(String feeType) {
					this.feeType = feeType;
				}

				public String getFeeName() {
					return feeName;
				}

				public void setFeeName(String feeName) {
					this.feeName = feeName;
				}

				public String getDate() {
					return date;
				}

				public void setDate(String date) {
					this.date = date;
				}

			}
		}
	}

}
