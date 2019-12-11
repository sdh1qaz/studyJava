package 日期处理;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

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
	 * 获取前天系统年月日（yyyyMMdd）
	 */
	public static String getYestYMD() {
		//当前系统年月日（yyyyMMdd）
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -1);
		Date date = cal.getTime();
		return new SimpleDateFormat("yyyyMMdd").format(date);
	}
	
	/**
	 * 获取6天前当天系统年月日（yyyyMMdd）
	 */
	public static String get6DaysBefYMD() {
		//当前系统年月日（yyyyMMdd）
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -6);
		Date date = cal.getTime();
		return new SimpleDateFormat("yyyyMMdd").format(date);
	}
	
	/**
	 * 获取半年前的系统年月日
	 */
	public static String getHalfYMD() {
		//当前系统年月日（yyyyMMdd）
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -6);
		Date date = cal.getTime();
		return new SimpleDateFormat("yyyyMMdd").format(date);
	}
	
	
	/**
	 * 获取当前系统年月（yyyyMM）
	 */
	public static String getNowYM() {
		//当前系统年月（yyyyMM）
		return new SimpleDateFormat("yyyyMM").format(new Date());
	}
	
	/**
	 * 获取当前系统年月（2019-10-20 03:56:19）
	 */
	public static String getNowDate() {
		//当前系统年月（yyyyMM）
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	/**
	 * 是否已出账，true是，false否
	 * 
	 */
	public static boolean isOutBill(String accountDay) {
		String day = new SimpleDateFormat("dd").format(new Date());
		System.out.println(day);
		if (day.startsWith("0")) {
			day = day.substring(1);
		}
		//出账日大于今天，表示没出账
		if (Integer.valueOf(accountDay) > Integer.valueOf(day)) {
			return false;
		}
		return true;
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
	
	/**
	 * 给定一个时间字符串yyyyMMdd，判断距离现在是否在3个月以内（含）
	 */
	public static boolean less3Mon(String date) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -3);
		Date d = cal.getTime();
		//距离现在3月之前那一刻的年月日字符串
		String dStr = new SimpleDateFormat("yyyyMMdd").format(d);
		return date.compareTo(dStr) > 0;
	}
	
	@Test
	public void test() {
		/*System.out.println(getNowYM());
		System.out.println(getLastYM());
		System.out.println(less3Mon("20190125"));
		System.out.println(getYestYMD());*/
		//System.out.println("20191031 10:40".compareTo("20191031 10:31"));
		/*System.out.println(get6DaysBefYMD());
		System.out.println(getNowDate());*/
		System.out.println(isOutBill("16"));
		System.out.println(isOutBill("3"));
		
	}

}
