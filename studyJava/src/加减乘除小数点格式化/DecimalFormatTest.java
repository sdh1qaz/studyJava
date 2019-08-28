package 加减乘除小数点格式化;

import java.text.DecimalFormat;

import org.junit.Test;

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
	}
}
