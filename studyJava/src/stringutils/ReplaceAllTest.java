package stringutils;
/**
 * @ClassName： ReplaceAllTest
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2018年5月15日
 */

public class ReplaceAllTest {
    public static void main(String[] args) {
		String ttString = "你好，（支持流量结转）";
		
		System.out.println(ttString.replaceAll("（支持流量结转）", "%%%%%"));
	}
}
