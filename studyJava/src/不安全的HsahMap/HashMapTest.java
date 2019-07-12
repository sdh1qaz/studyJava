package 不安全的HsahMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName： HashMapTest
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年7月12日
 */

public class HashMapTest {

	public static void main(String[] args) {
		Map< String, String> hashMap = new HashMap<>();
		hashMap.put("a.b.c", "12345");
		System.out.println(hashMap.get("a.b.c"));
	}
}
