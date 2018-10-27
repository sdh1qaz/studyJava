/**
 * @ClassName： FinalizeTest
 * @Author: dhSu
 * @Description: finalize()方法学习
 * @Date:Created in 2018年10月10日
 */

public class FinalizeTest {
	void say() {
		System.out.println("nihao");
	}
	public static void main(String[] args) throws Throwable {
		FinalizeTest finalizeTest = new FinalizeTest();
		finalizeTest.say();
		finalizeTest.finalize();
		finalizeTest.say();
	}

}
