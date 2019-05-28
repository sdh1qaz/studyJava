package com.dhsu.stringutils;

import org.junit.Test;

/**
 * @ClassName： SubStringTest
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年5月27日
 */

public class SubStringTest {
	
	@Test
	public void testSubString() {
		String effDate = "20190501000000";
		System.out.println(effDate.trim().substring(0, 6));
	}

}
