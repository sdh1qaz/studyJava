package 包装类;
/**
 * @ClassName： IntegerTest
 * @Author: dhSu
 * @Description:Integer与int互转
 * @Date:Created in 2019年2月1日
 */

import org.junit.Test;

public class IntegerTest {
	
	//Integer与int互转
	@Test
	public void transform() {
		int i = 10;
		Integer ib = Integer.valueOf(i);
		//ib是否是对象
		System.out.println(ib instanceof Integer);
		int a = ib.intValue();
		System.out.println(a);
	}
}
