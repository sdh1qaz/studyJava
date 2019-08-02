package 字符串操作StringUtils;
/**
 * @ClassName： ContainsMethod
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年1月9日
 */

public class ContainsMethod {
	
	public static void main(String[] args) {
		String string = "17737112691,123";
		if (string.contains("17737112691")) {
			System.out.println("特殊号码");
		}else {
			System.out.println("普通号码");
		}
		
	}

}
