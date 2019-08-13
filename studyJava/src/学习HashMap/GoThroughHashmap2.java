package 学习HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @ClassName： GoThroughHashmap2
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2018年11月17日
 */

public class GoThroughHashmap2 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String,String>();
		for(int i=0;i<10;i++) {
			map.put("" + i, "value_" + i);
		}
		
		for(Entry<String,String> entrySet : map.entrySet()) {
			System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
		}
	}

}
