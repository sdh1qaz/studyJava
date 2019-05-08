package com.dhsu.stringutils;

import org.junit.Test;

/**
 * @ClassName： SpiltTest
 * @Author: dhSu
 * @Description:测试spilt方法
 * @Date:Created in 2019年5月8日
 */

public class SpiltTest {
	
	@Test
	public void testSpilt() {
		String s = "你-们-好-";
		String[] sArr = s.split("-");
		for(String st : sArr) {
			System.out.println(st);
		}
		System.out.println(sArr.length);
	}
}
