package treeset;
/**
 * @ClassName： LinkedHashSetTest
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2018年3月14日
 */

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetTest {
	
	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<String>();//检测LinkedHashSet按插入顺序存储
		set.add("88");
		set.add("45");
		set.add("34");
		
		for(String str:set)
			System.out.println(str);
	}
    
}
