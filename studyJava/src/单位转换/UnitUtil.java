package 单位转换;

import org.junit.Test;
import org.springframework.util.StringUtils;

/**
 * 单位转换
 * @Date:Created in 2019年8月2日
 */

public class UnitUtil {

	/**
	 * 流量后加M，如0.00变成0.00M
	 */
	public static String addM(String flow) {
		if(StringUtils.isEmpty(flow) || flow.endsWith("M")) {
			return flow;
		}
		return flow + "M";
	}
	
	@Test
	public void test() {
		System.out.println(addM(""));
	}
}
