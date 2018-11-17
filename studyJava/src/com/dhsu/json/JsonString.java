package com.dhsu.json;
/**
 * @ClassName： JsonString
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2018年11月17日
 */

public class JsonString {
	public static void main(String[] args) {
		String voiceCall = "500";
		String dataFlow = "1000";
		
		//String data = "{\"telephone\":\"187xxxx1941\",\"voiceCall\":\"xx\",\"dataFlow\":\"xx\"}";
		
		String data1 = "{\"telephone\":\"" + "187xxxx1941" + "\",\"voiceCall\":\"" + voiceCall + 
						"\",\"dataFlow\":\"" + dataFlow + "\"}";
		System.out.println(data1);
	}

}
