package 正则表达式;

import org.junit.Test;

/**
 * 密码工具
 */

public class PwdUtil {

	/**
	 * 是否为简单密码
	 * 判断规则：不能为连续数字、必须为6位数字、
	 * 不能6个相同数字、不能是手机号中的6个连续数字
	 */
	public static boolean isSimplePwd(String pwd,String telnum) {
		 //6位数字
		String reg0 = "^\\d{6}$";
		// 数字不是连续的
		String reg1 = "^(?:(\\d)(?!((?<=9)8|(?<=8)7|(?<=7)6|(?<=6)5|"
				+ "(?<=5)4|(?<=4)3|(?<=3)2|(?<=2)1|(?<=1)0){5})(?!\1{5})"
				+ "(?!((?<=0)1|(?<=1)2|(?<=2)3|(?<=3)4|(?<=4)5|(?<=5)6|(?<=6)7|(?<=7)8|(?<=8)9){5})){6}$";
		//数字不是6个重复的数字
		String reg2 = "^(?=.*\\d+)(?!.*?([\\d])\\1{5})[\\d]{6}$";
		if (!pwd.matches(reg0) || !pwd.matches(reg1) ||
				!pwd.matches(reg2) || telnum.contains(pwd)) {
			return true;
		}
		return false;
	}
	
	@Test
	public void test() {
		System.out.println(isSimplePwd("123456", "17737112692"));
	}
}
