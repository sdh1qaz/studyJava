package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName： LoggerHandler
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年2月11日
 */

public class LoggerHandler implements InvocationHandler{
	private Object target;
	
	public LoggerHandler(Object target) {
		this.target = target;
	}
	
	public Object invoke(Object proxy,Method method,Object[] args) throws Throwable{
		System.out.println("开始调用方法");
		Object res = method.invoke(target, args);
		System.out.println("调用方法结束");
		return res;
	} 
}
