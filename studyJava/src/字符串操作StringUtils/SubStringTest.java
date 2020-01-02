package 字符串操作StringUtils;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.Test;

/**
 * @ClassName： SubStringTest
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年5月27日
 */

public class SubStringTest {
	
	@Test
	public void testSubString() {
		String effDate = "20190501000000";
		System.out.println(effDate.trim().substring(0, 6));
	}
	
	@Test
	public void testSubString1() {
		String puk = "PIN1:1234PIN2:1687PUK1:09147060PUK2:47978599";
		int index_1 = puk.indexOf("PUK1:");
		int index_2 = puk.indexOf("PUK2:");
		String puk1 = puk.substring(index_1 + 5,index_2);
		String puk2 = puk.substring(index_2 + 5);
		System.out.println("puk1=" + puk1);
		System.out.println("puk2=" + puk2);
	}
	
	@Test
	public void test() {
		String reg = "^((100)|(\\d{1,2}))$";
		System.out.println("10".matches(reg));
	}
	

}
