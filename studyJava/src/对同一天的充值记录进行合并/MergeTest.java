package 对同一天的充值记录进行合并;

import java.util.ArrayList;
import java.util.Arrays;
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

	
	public List<BillInfo> mergeItems(List<BillInfo> bfs){
		int size = bfs.size();
		if (size == 0) {
			return null;
		}
		for(int i=0;i<size;i++) {
			if ("has_been_merged".equals(bfs.get(i).getBillItemId())) {
				continue;
			}
			for(int j=i+1;j<size;j++) {
				if ("has_been_merged".equals(bfs.get(j).getBillItemId())) {
					continue;
				}
				if (bfs.get(i).getBillItemId().equals(bfs.get(j).getBillItemId())) {
					int fee = Integer.valueOf(bfs.get(i).getFee());
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
	
	
	@Test
	public void test() {
		List<BillInfo> bfs = new ArrayList<>();
		bfs.add(new BillInfo("1", "10000"));
		bfs.add(new BillInfo("3", "20000"));
		bfs.add(new BillInfo("4", "20000"));
		bfs.add(new BillInfo("4", "20000"));
		bfs.add(new BillInfo("3", "20000"));
		bfs.add(new BillInfo("1", "10000"));
		bfs.add(new BillInfo("1", "10000"));
		bfs.add(new BillInfo("2", "10000"));
		bfs.add(new BillInfo("1", "10000"));
		bfs.add(new BillInfo("1", "30000"));
		bfs.add(new BillInfo("1", "30000"));
		bfs.add(new BillInfo("4", "30000"));
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
}
