package 流程控制;

import org.junit.Test;

/**
 * @ClassName： IF_Switch_Else
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年11月11日
 */

public class IF_Switch_Else {

	/**
	 * 测试switch语句
	 */
	@Test
	public void test() {
		String str = "a";
		switch (str) {
		case "a":
			System.out.println("匹配a");
		case "b":
			System.out.println("匹配b");
			break;
		case "c":
			System.out.println("匹配c");
			break;
		default:
			System.out.println("匹配默认");
			break;
		}
	}
}
