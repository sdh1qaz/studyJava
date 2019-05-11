package 运算符;

import org.junit.Test;

/**
 * @ClassName： OperatorTest
 * @Author: dhSu
 * @Description: 学习java中的运算符
 * @Date:Created in 2019年5月11日
 */

public class OperatorTest {
	
	static final int MAXIMUM_CAPACITY = 1 << 30;
	
	//和  >>>
	/*>>>是无符号右移
	 */
	public int testOperator1(int cap){
		int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
	}
	
	@Test
	public void test() {
		System.out.println(testOperator1(10));
	}
	
	//学习 |=
	//a |= 2，相当于a = a | 2
	@Test
	public void testOperator2() {
		int a = 10;
		printInfo(a);
		printInfo(15);
		a |= 15;
		printInfo(a);
		System.out.println(a);
	}
	
	public void printInfo(int num) {
		System.out.println(Integer.toBinaryString(num));
	}
}
