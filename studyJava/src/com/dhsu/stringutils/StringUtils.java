package com.dhsu.stringutils;

/**
 * @ClassName： StringUtils
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年5月7日
 */

public class StringUtils {
	
	/**
	* @Description: 字符串每个字符后都加上p[n],使得播报延时n毫秒
	* @param str 需要处理的字符串
	* @param milliSeconds 延时的好秒数
	* @return String 处理后的字符串，etc：p[200]你p[200]们p[200]好
	* @throws
	 */
	public static String addPn(String str,String milliSeconds) {
		StringBuffer sb = new StringBuffer();
		//延时毫秒数
		String m = "p[" + milliSeconds + "]";
		//字符串变为字符数组
		char[] cArr = str.trim().toCharArray();
		for(char c : cArr) {
			sb.append(m + c);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(addPn("你们好", "200"));
	}
}
