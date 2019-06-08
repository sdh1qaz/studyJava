package com.dhsu.stringutils;

import org.junit.Test;

/**
 * @ClassName： StringBuilderTest
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年6月8日
 */

public class StringBuilderTest {

	@Test
	public void testDelete() {
		StringBuilder sb = new StringBuilder();
		sb.append("1234567890");
		System.out.println("调用delete方法之前：" + sb.toString());
		sb.delete(0, sb.length());
		System.out.println("调用delete方法之后：" + sb.toString());
	}
}
