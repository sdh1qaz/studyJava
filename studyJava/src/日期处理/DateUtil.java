package 日期处理;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
	
	/**
	 * 获取当前系统年月日（yyyyMMdd）
	 */
	public static String getNowYMD() {
		//当前系统年月日（yyyyMMdd）
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
	}
	
	/**
	 * 获取当前系统年月（yyyyMMdd）
	 */
	public static String getNowYM() {
		//当前系统年月（yyyyMM）
		return new SimpleDateFormat("yyyyMM").format(new Date());
	}
	
	/**
	 * 获取上月年月yyyyMM
	 */
	public static String getLastYM() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		Date d = cal.getTime();
		return new SimpleDateFormat("yyyyMM").format(d);
	}
	
	@Test
	public void test() {
		System.out.println(getNowYM());
		System.out.println(getLastYM());
	}

}
