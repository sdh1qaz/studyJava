package hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 参考：http://blog.csdn.net/u010127245/article/details/50937384
 * @author Administrator
 */
public class GoThroughHashMap {
   public static void main(String[] args) {
	   Map<String,String> map = new HashMap<String,String>();
	   //插入数据
	   for(int i=0;i<8050;i++){
		   map.put("key" + i,"value" + i);
	   } 
	   //方法一 效率高的
	   /**
	    * entrySet()的返回值也是返回一个Set集合，此集合的类型为Map.Entry。
          Map.Entry是Map声明的一个内部接口，此接口为泛型，定义为Entry<K,V>。
                                 它表示Map中的一个实体（一个key-value对）。接口中有getKey(),getValue方法。
	    */
	   Iterator iter = map.entrySet().iterator();
	   int count = 0;
	   while (iter.hasNext()) {
           Map.Entry entry = (Map.Entry) iter.next();
           Object key = entry.getKey();
           Object val = entry.getValue();
           System.out.println(key + " -- " + val);
	   }
   }
}
