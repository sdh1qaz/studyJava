/**
 * @ClassName： GetCurrentMethodName
 * 
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2018年9月18日
 */

public class GetCurrentMethodName {
	public static void main(String[] args) {
		say();
	}
	
	public static void say() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
	}
}
