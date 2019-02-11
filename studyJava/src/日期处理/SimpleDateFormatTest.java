package 日期处理;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName： SimpleDateFormatTest
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2018年12月30日
 */










public class SimpleDateFormatTest {
	
	public static String getNowDate() {
		Date current = new Date();
		SimpleDateFormat df = new SimpleDateFormat("YYYYMMddHHmmss");
		String dateString = df.format(current);
		return dateString;
	}
	
	public static void main(String[] args) {
		System.out.println(getNowDate());
	}
}
