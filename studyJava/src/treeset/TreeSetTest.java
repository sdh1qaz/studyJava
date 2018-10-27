package treeset;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName： TreeSetTest
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2018年3月14日
 */

public class TreeSetTest {
   public static void main(String[] args) {
	  /*Set<String> set = new TreeSet<String>();//测试TreeSet的存储自动排序
	  set.add("1");
	  set.add("7");
	  set.add("3");*/
	   
	   Set<String> set = new HashSet<String>();//测试TreeSet的有序性
	   set.add("5");
	      set.add("34");
		  set.add("7");
		  
	  
		  
	  for(String str:set)
		  System.out.println(str);
   }
}
