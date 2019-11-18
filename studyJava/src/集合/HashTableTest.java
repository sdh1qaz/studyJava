package 集合;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName： HashTable
 * @Author: dhSu
 * @Description: 学习HashTable
 * @Date:Created in 2019年1月25日
 */

public class HashTableTest {
	public static void main(String[] args) {
		Hashtable<String, String> hashtable = new Hashtable<String,String>();
		//hashtable.put(null, null);
		hashtable.put("k1", "v1");
		hashtable.put("k2", "v2");
		hashtable.put("k3", "v3");
		hashtable.put("k4", "v4");
		hashtable.put("k5", null);
		System.out.println(hashtable);
		Collection<String> values = hashtable.values();
		Iterator<String> iterator = values.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		Set<String> keySet = hashtable.keySet();
		Iterator<String> iterator2 = keySet.iterator();
		while(iterator2.hasNext()) {
			System.out.println(iterator2.next());
		}
	}
}
