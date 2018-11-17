package com.dhsu.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
}
