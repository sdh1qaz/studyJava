/**
 * @ClassName： MethodWithThreePoint
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2018年11月20日
 */

public class MethodWithThreePoint {
	
	public static void say(String... str) {
		for(String s : str) {
			System.out.println(s + "你好！");
		}
	}
	public static void say(int... i) {
		for(int s : i) {
			System.out.println(s + "你好！");
		}
	}
	
	public static void main(String[] args) {
		say("苏登辉","李登辉","赵登辉");
		say(1,2,3,4,5);
	}

}
