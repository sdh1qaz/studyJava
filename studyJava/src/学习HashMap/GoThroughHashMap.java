package 学习HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.jws.soap.SOAPBinding.Use;

import org.junit.Test;

public class GoThroughHashMap {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < 8050; i++) {
			map.put("key" + i, "value" + i);
		}
		
		Iterator iter = map.entrySet().iterator();
		int count = 0;
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			Object val = entry.getValue();
			System.out.println(key + " -- " + val);
		}
	}
	
	class User{
		private String name;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "User [name=" + name + "]";
		}
	}
	
	@Test
	public void test() {
		User user = new User();
		user.setName("苏登辉");
		Map<String, User> map = new HashMap<String, User>();
		map.put("obj1", user);
		map.put("obj2", user);
		System.out.println(map.get("obj1"));
		System.out.println(map.get("obj2"));
		System.out.println(map.get("obj1") == map.get("obj2"));
		System.out.println("********************************");
		user.setName("李白");
		System.out.println(map.get("obj1"));
		System.out.println(map.get("obj2"));
		System.out.println(map.get("obj1") == map.get("obj2"));
		System.out.println("********************************");
		System.out.println(map.values().size());
	}
}
