package arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName： ArrayListTest
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2018年3月14日
 */

public class ArrayListTest {
     public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("大家好");
		list.add("我好");
		list.add("你好");
		
		for(String str:list)
			System.out.println(str);
	}
}
