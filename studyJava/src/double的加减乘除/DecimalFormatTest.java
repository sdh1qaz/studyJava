package double的加减乘除;

import java.text.DecimalFormat;

public class DecimalFormatTest {
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#.##");
		DecimalFormat df1 = new DecimalFormat("0.0000");
		double d = 3.146;
		System.out.println(df.format(d));
		System.out.println(df1.format(d));
	}
	
}
