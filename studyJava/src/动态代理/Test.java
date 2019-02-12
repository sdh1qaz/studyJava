package 动态代理;

import java.lang.reflect.Proxy;

/**
 * @ClassName： Test
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年2月11日
 */

public class Test {
	public static void main(String[] args) {
		IHello hw = new HelloWorld();
		LoggerHandler handler = new LoggerHandler(hw);
		IHello proxy = (IHello)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), 
				hw.getClass().getInterfaces(), handler);
		proxy.sayHello();
	}
}
