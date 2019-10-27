package 正则表达式;

import org.junit.Test;

/**
 * 身份证校验
 */

public class IDValidator {
	
	/**
	 * 身份证格式的正则校验
	 */
	public static boolean verForm(String id) {
		String reg = "^\\d{15}$|^\\d{17}[0-9Xx]$";
		if (!id.matches(reg)) {
			return false;
		}
		return true;
	}
	
	@Test
	public void test() {
		System.out.println(verForm("410425198912065539"));
	}
}
