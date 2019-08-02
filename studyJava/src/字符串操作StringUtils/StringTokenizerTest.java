package 字符串操作StringUtils;

import java.util.StringTokenizer;

/**
 * @ClassName： StringTokenizerTest
 * @Author: dhSu
 * @Description:StringTokenizer 解析格式化的输入字符串
 * @Date:Created in 2018年11月13日
 */

public class StringTokenizerTest {
	static String in = "title=Java:The Complete Reference;" + "author=schildt;"+
						"publisher=sudenghui";
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer(in, "=;");
		while(st.hasMoreTokens()) {
			String key = st.nextToken();
			String val = st.nextToken();
			System.out.println(key + '\t' + val);
		}
 	}
}
