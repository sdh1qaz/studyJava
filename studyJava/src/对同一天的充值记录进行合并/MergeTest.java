package 对同一天的充值记录进行合并;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @ClassName： MergeTest
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年11月28日
 */

public class MergeTest {
	
	public class BillInfo{
		private String fee;
		private String billItemId;
		
		public BillInfo(String fee, String billItemId) {
			super();
			this.fee = fee;
			this.billItemId = billItemId;
		}

		public String getFee() {
			return fee;
		}

		public void setFee(String fee) {
			this.fee = fee;
		}

		public String getBillItemId() {
			return billItemId;
		}

		public void setBillItemId(String billItemId) {
			this.billItemId = billItemId;
		}

		@Override
		public String toString() {
			return "BillInfo [fee=" + fee + ", billItemId=" + billItemId + "]";
		}

	}

	/**
	 * billItemId相同的金额作合并处理
	 */
	public List<BillInfo> mergeItems(List<BillInfo> bfs){
		int size = bfs.size();
		if (size == 0) {
			return bfs;
		}
		for(int i=0;i<size;i++) {
			if ("has_been_merged".equals(bfs.get(i).getBillItemId())) {
				continue;
			}
			for(int j=i+1;j<size;j++) {
				if ("has_been_merged".equals(bfs.get(j).getBillItemId())) {
					continue;
				}
				int fee = Integer.valueOf(bfs.get(i).getFee());
				String billItemId_i = bfs.get(i).getBillItemId();
				if (billItemId_i.equals(bfs.get(j).getBillItemId())) {
					fee += Integer.valueOf(bfs.get(j).getFee());
					bfs.get(i).setFee(String.valueOf(fee));
					bfs.get(j).setBillItemId("has_been_merged");
				}
			}
		}
		//已经被合并过的明细过滤掉
		List<BillInfo> mer = new ArrayList<>();
		for (BillInfo b : bfs) {
			if (!"has_been_merged".equals(b.getBillItemId())) {
				mer.add(b);
			}
		}
		return mer;
	}
	
	/**
	 * 
	 */
	
	@Test
	public void testMergeItems() {
		List<BillInfo> bfs = new ArrayList<>();
		bfs.add(new BillInfo("1", "10000"));
		bfs.add(new BillInfo("1", "20000"));
		bfs.add(new BillInfo("1", "20000"));
		bfs.add(new BillInfo("1", "20000"));
		bfs.add(new BillInfo("1", "20000"));
		bfs.add(new BillInfo("1", "10000"));
		bfs.add(new BillInfo("1", "10000"));
		bfs.add(new BillInfo("1", "10000"));
		bfs.add(new BillInfo("1", "10000"));
		bfs.add(new BillInfo("1", "30000"));
		bfs.add(new BillInfo("1", "30000"));
		bfs.add(new BillInfo("1", "30000"));
		bfs.add(new BillInfo("1", "30000"));
		bfs.add(new BillInfo("1", "30000"));
		
		for(BillInfo b : bfs) {
			System.out.println(b.toString());
		}
		
		System.out.println("**************************************************");
		List<BillInfo> mer = mergeItems(bfs);
		for(BillInfo b : mer) {
			System.out.println(b.toString());
		}
	}
	
	public class  PayRec{
		
		public PayRec(String amount, String payDate) {
			super();
			this.amount = amount;
			this.payDate = payDate;
		}
		private String amount;//缴费金额
		private String channelId;//缴费渠道
		private String payType;//缴费方式
		private String payDate;//缴费日期格式
		private String payTypeName;//缴费方式名称
		
		public String getAmount() {
			return amount;
		}
		public void setAmount(String amount) {
			this.amount = amount;
		}
		public String getChannelId() {
			return channelId;
		}
		public void setChannelId(String channelId) {
			this.channelId = channelId;
		}
		public String getPayType() {
			return payType;
		}
		public void setPayType(String payType) {
			this.payType = payType;
		}
		public String getPayDate() {
			return payDate;
		}
		public void setPayDate(String payDate) {
			this.payDate = payDate;
		}
		public String getPayTypeName() {
			return payTypeName;
		}
		public void setPayTypeName(String payTypeName) {
			this.payTypeName = payTypeName;
		}
		@Override
		public String toString() {
			return "PayRec [amount=" + amount + ", channelId=" + channelId + ", payType=" + payType + ", payDate="
					+ payDate + ", payTypeName=" + payTypeName + "]";
		}
		
	}
	
	/**
	* @Description: 
	* 1、有一笔缴费记录金额为负数，且与相邻的前一笔缴费金额数值相同，则这两笔均不播报
	* 2、有一笔缴费记录金额为负数，且与相邻的前一笔缴费金额数值不同，则此笔负数金额缴费记录不播报，其他正常播报
	*/
	public List<PayRec> remNegRecords(List<PayRec> pl){
		//实现规则1
		int size = pl.size();
		if (size == 0) {
			return pl;
		}
		for(int i=0;i<size;i++) {
			if ("will_be_cleared".equals(pl.get(i).getPayType())) {
				continue;
			}
			for(int j=i+1;j<size;j++) {
				if ("will_be_cleared".equals(pl.get(j).getPayType())) {
					continue;
				}
				if (Double.valueOf(pl.get(i).getAmount()) == 0 - 
						Double.valueOf(pl.get(j).getAmount())) {
					pl.get(i).setPayType("will_be_cleared");
					pl.get(j).setPayType("will_be_cleared");
					break;
				}
			}
		}
		//已经被标记过的明细过滤掉
		List<PayRec> cle = new ArrayList<>();
		for (PayRec p : pl) {
			if (!"will_be_cleared".equals(p.getPayType())) {
				cle.add(p);
			}
		}
		//实现规则2，去掉有负数的
		List<PayRec> res = new ArrayList<>();//最终返回的
		for(PayRec c : cle) {
			if (Double.valueOf(c.getAmount()) > 0) {
				res.add(c);
			}
		}
		return res;
	}
	
	/**
	 * @Description: 
	 * 受理时间一样的两笔或多笔进行累加播报
	 */
	public List<PayRec> mergeSameDayRecords(List<PayRec> pl){
		//实现规则1
		int size = pl.size();
		if (size == 0) {
			return pl;
		}
		for(int i=0;i<size;i++) {
			if ("has_be_merged".equals(pl.get(i).getPayType())) {
				continue;
			}
			for(int j=i+1;j<size;j++) {
				if ("has_be_merged".equals(pl.get(j).getPayType())) {
					continue;
				}
				double fee = Double.valueOf(pl.get(i).getAmount());
				String ymd = pl.get(i).getPayDate().substring(0,8);
				if (ymd.equals(pl.get(j).getPayDate().substring(0,8))) {
					fee += Double.valueOf(pl.get(j).getAmount());
					pl.get(i).setAmount(String.valueOf(fee));
					pl.get(j).setPayType("has_be_merged");
				}
			}
		}
		//已经被标记过的明细过滤掉
		List<PayRec> cle = new ArrayList<>();
		for (PayRec p : pl) {
			if (!"has_be_merged".equals(p.getPayType())) {
				cle.add(p);
			}
		}
		return cle;
	}
	
	@Test
	public void testRemNegRecords() {
		List<PayRec> pl = new ArrayList<>();
		pl.add(new PayRec("100.25","20191011"));
		pl.add(new PayRec("100.25","20191010"));
		pl.add(new PayRec("100.25","20191010"));
		pl.add(new PayRec("100.25","20191015"));
		pl.add(new PayRec("-100.25","20191015"));
		pl.add(new PayRec("100.25","20191010"));
		pl.add(new PayRec("-100.29","20191010"));
		
		for (PayRec p : pl) {
			System.out.println(p.toString());
		}
		System.out.println("*************************************");
		List<PayRec> re = mergeSameDayRecords(remNegRecords(pl));
		for (PayRec pa : re) {
			System.out.println(pa.toString());
		}
	}
	
}
