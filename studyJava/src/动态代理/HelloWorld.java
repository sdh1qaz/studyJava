package 动态代理;
/**
 * @ClassName： HelloWorld
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年2月11日
 */

public class HelloWorld implements IHello{
	public void sayHello() {
		System.out.println("Hello java");
	}
	public static void main(String[] args) {
		new HelloWorld().sayHello();
	}
}
