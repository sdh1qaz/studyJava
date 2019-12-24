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
	
	public static boolean isSimplePwd1(String pwd) {
		String reg1 = "(\\d)\\1{1}(\\d)\\2{1}(\\d)\\3{1}";//匹配AABBCC
		String reg2 = "(\\d)\\1{0}(\\d)\\2{4}";//匹配ABBBBB
		String reg3 = "(\\d)\\1{1}(\\d)\\2{3}";//匹配AABBBB
		String reg4 = "(\\d)\\1{2}(\\d)\\2{2}";//匹配AAABBB
		String reg5 = "(\\d)\\1{3}(\\d)\\2{1}";//匹配AAAABB
		String reg6 = "(\\d)\\1{4}(\\d)\\2{0}";//匹配AAAAAB
		String reg7 = "(\\d)\\1{5}";//匹配AAAAAA
		return pwd.matches(reg1) || pwd.matches(reg2) || pwd.matches(reg3)
				|| pwd.matches(reg4) || pwd.matches(reg5) || pwd.matches(reg6)
				|| pwd.matches(reg7);
	}
	
	@Test
	public void test() {
		System.out.println(isSimplePwd1("123456"));
	}
}
