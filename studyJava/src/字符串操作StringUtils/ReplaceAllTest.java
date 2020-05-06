package 字符串操作StringUtils;

import org.junit.Test;

/**
 * @ClassName： ReplaceAllTest
 * 
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2018年5月15日
 */

public class ReplaceAllTest {
	public static void main(String[] args) {
		String ttString = "你好，（支持流量结转）";

		System.out.println(ttString.replaceAll("（支持流量结转）", "%%%%%"));
	}

	@Test
	public void test() {
		String desc = "改用户订购了[大刘昂1234567890]";
		String deString = desc.substring(0, desc.indexOf("]"));
		desc = deString.replace("改用户订购了[", "");
		System.out.println(desc);
	}
	
	@Test
	public void test1() {
		String desc = "你好\t世界";
		System.out.println(desc);
		System.out.println(desc.replace("\t", ""));
	}
	
	@Test
	public void test2() {
		String desc = "你好\\t世界";
		System.out.println(desc);
		System.out.println(desc.replace("\\t", ""));
	}
}
