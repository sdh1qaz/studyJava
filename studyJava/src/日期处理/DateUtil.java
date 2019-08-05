package 日期处理;

import org.junit.Test;

/**
 * @ClassName： DateUtil
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年8月2日
 */

public class DateUtil {
	
	/**
	 * 分钟转化为XX小时XX分
	 * 例：70分--1小时10分
	 */
	public static String minuteFormat(String minute) {
		double d = Double.valueOf(minute);
		int min = (int)d;
		if (min < 60) {
			return min + "分";
		}
		return min/60 + "小时" + min%60 + "分"; 
	}
	
	@Test
	public void test() {
		System.out.println(minuteFormat("68.800"));
		System.out.println(minuteFormat("698.000"));
		System.out.println(minuteFormat("8.000"));
	}

}
