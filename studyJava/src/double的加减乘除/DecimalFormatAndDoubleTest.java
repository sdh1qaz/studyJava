package double的加减乘除;

import java.text.DecimalFormat;

import com.alibaba.fastjson.JSONObject;

public class DecimalFormatAndDoubleTest {
	public static JSONObject generateFlowUnitValue(String numStr) {
        JSONObject obj = new JSONObject();
        String unit = "MB";
        String value = numStr;
        float num = Float.parseFloat(numStr);
        if (num > 1024) {
            unit = "GB";
            value = String.valueOf((float) Math.round(num / 1024 * 100) / 100);
        }
        obj.put("Unit", unit);
        obj.put("value", value);
        return obj;
    }
	public static void main(String[] args) {
		/*DecimalFormat df = new DecimalFormat("#.##");
		DecimalFormat df1 = new DecimalFormat("0.0000");
		DecimalFormat df2 = new DecimalFormat("0.00");
		double d = 0.00;
		System.out.println(df.format(d));
		System.out.println(df1.format(d));
		System.out.println(df2.format(d));
		System.out.println((float)Math.round(3045 / 1024 * 100) / 100);*/
		System.out.println(generateFlowUnitValue("3000"));
		/*double的除法至少要有一个数为doule*/
		System.out.println(5/2.0);
		System.out.println(5/2);
		System.out.println(5.0/2);
		System.out.println(5.0/2.0);
		
	}
	
}
