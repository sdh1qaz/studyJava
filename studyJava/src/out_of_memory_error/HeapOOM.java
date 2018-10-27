package out_of_memory_error;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName： HeapOOM
 * @Author: dhSu
 * @Description:java堆内存溢出异常测试
 * @Date:Created in 2018年5月8日
 */

/**
 * java堆用于存储对象实例，只要不断地创建对象，并且保证GC Roots到对象之间有可达路径来避免
 * 垃圾回收机制来清楚这些对象，那么在对象数量达到最大堆容量限制后就会产生内存溢出异常
 */

/**
   VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
   static class OOMObject{}
   
   public static void main(String[] args) {
	   List<OOMObject> list = new ArrayList<OOMObject>();
	   while(true) {
		   list.add(new OOMObject());
	   }
   }
}
