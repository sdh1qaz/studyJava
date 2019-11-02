package double的加减乘除;

import java.text.DecimalFormat;

import org.junit.Test;

public class MinusTest {

	//两个double相减
	public double minus(double a,double b) {
		return a - b;
	}
	
	@Test
	public void test() {
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println(df.format(minus(5.36, 2.30)));
	}
}
