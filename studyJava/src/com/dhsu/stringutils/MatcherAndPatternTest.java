package com.dhsu.stringutils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * @ClassName： MatcherAndPatternTest
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年5月20日
 */

public class MatcherAndPatternTest {
	
	@Test
	public void testMatchAndPattern() {
		
		String pwd = "112345";
		String reg = "[\\d]{6}";// \d匹配数字
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(pwd);
		
		if (!matcher.matches()) {
			throw new RuntimeException("密码不正确");
		}else {
			System.out.println("校验通过");
		}
	}
}
