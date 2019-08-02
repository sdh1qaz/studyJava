package 字符串操作StringUtils;

import org.junit.Test;

/**
 * @ClassName： FormatTest
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年5月29日
 */

public class FormatTest {

	@Test
	public void testStringFormat() {
		String cityId = "4865";
		String cString;
		cString = cityId.length() < 4 ? String.format("%4s", cityId).replace(" ", "0") : cityId;
		System.out.println(cString);
	}
}
