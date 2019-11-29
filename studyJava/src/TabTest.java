import java.awt.print.Printable;

import org.junit.Test;

/**
 * @ClassName： TabTest
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2018年10月28日
 */

public class TabTest {
	public static void main(String[] args) {
		System.out.print("学号\t姓名\t语文\t数学\t英语\n");
		System.out.print("2017001\t曹操\t99\t88\t0\n") ;
		System.out.print("2017002\t周瑜\t92\t45\t93\n");
		System.out.print("2017008\t黄盖\t77\t82\t100\n");
	}

	@Test
	public void test() {
		String a,b,c = "";
		a="A";
		b="B";
		c="C";
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
