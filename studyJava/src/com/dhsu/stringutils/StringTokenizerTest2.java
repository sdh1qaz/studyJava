package com.dhsu.stringutils;

import java.util.StringTokenizer;

/**
 * @ClassName： StringTokenizerTest2
 * @Author: dhSu
 * @Description:文本解析
 * @Date:Created in 2018年11月13日
 */

public class StringTokenizerTest2 {
	static String in = "路不铲不平，事不为不成;人不劝不善，钟不打不鸣.";
	
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer(in, "，。;.");
		while(st.hasMoreTokens()) {
			String key = st.nextToken();
			System.out.println(key);
		}
	}
}
