package 随机类.random;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName： Random8
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年1月31日
 */

public class ConcurrentDateUtil {
	private static ThreadLocal<DateFormat> th = new ThreadLocal<DateFormat>() {
		@Override
		protected DateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMddHHmmss");
		}
	};
	
	//生成时间戳
	public static String getTimeStamp() {
		String stamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		System.out.println(stamp);
		return stamp;
	}
	
	public static void main(String[] args) {
		getTimeStamp();
	}
}
