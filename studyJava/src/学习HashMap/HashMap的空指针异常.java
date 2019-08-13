package 学习HashMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

/**
 * 
 */

public class HashMap的空指针异常 {
	
	private static Map<String, String> map = new ConcurrentHashMap();
	
	//测试HashMap的空指针异常
	@Test
	public void testNullPointException() {
		//map.put(null, "放入null会引起异常");
		map.get(null);
	}
	
	
	
	
}
