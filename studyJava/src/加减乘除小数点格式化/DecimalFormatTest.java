package 加减乘除小数点格式化;

import java.text.DecimalFormat;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * 
 */

public class DecimalFormatTest {

	@Test
	public void test() {
		DecimalFormat df = new DecimalFormat("######0.00");
		System.out.println(df.format(1111111178.0));
		System.out.println(new DecimalFormat("#").format(3.14));
		System.out.println(new DecimalFormat("0000.00").format(3.14));
		System.out.println(new DecimalFormat("####.000").format(3.14));
		System.out.println(new DecimalFormat("##00.000").format(3.14));
		System.out.println(div(9, 20));
	}
	
	/**
	 * 两个int相除结果保留2位小数，返回double
	 */
	public static double div(int num1,int num2) {
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.valueOf(df.format((double) num1 / (double)num2));
	}
	
}
