package 反射;

import org.junit.Test;

/**
 * @ClassName： Test
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年11月14日
 */

public class Test1 {
	
	/**
	 * 获取调用当前方法的的类名、方法名、行数
	 */
	@Test
	public void test3() {
		String className = Thread.currentThread().getStackTrace()[0].getClassName();// 当前方法的类名
		String methodName = Thread.currentThread().getStackTrace()[0].getMethodName();// 当前方法的方法名
		int lineNumber = Thread.currentThread().getStackTrace()[0].getLineNumber();// 当前的行数
		System.out.println(className);
		System.out.println(methodName);
		System.out.println(lineNumber);
		
		System.out.println("*****************************************************");
		
		className = Thread.currentThread().getStackTrace()[1].getClassName();//
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();//
		lineNumber = Thread.currentThread().getStackTrace()[1].getLineNumber();//
		System.out.println(className);
		System.out.println(methodName);
		System.out.println(lineNumber);
		
		System.out.println("*****************************************************");
		
		className = Thread.currentThread().getStackTrace()[2].getClassName();//
		methodName = Thread.currentThread().getStackTrace()[2].getMethodName();//
		lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();//
		System.out.println(className);
		System.out.println(methodName);
		System.out.println(lineNumber);
	}
	
	/**
	 * 获取调用当前方法的的类名、方法名、行数
	 */
	@Test
	public void test4() {
		String className = Thread.currentThread().getStackTrace()[0].getClassName();// 当前方法的类名
		String methodName = Thread.currentThread().getStackTrace()[0].getMethodName();// 当前方法的方法名
		int lineNumber = Thread.currentThread().getStackTrace()[0].getLineNumber();// 当前的行数
		System.out.println(className);
		System.out.println(methodName);
		System.out.println(lineNumber);
		
		for (int i = 1; i < 20; i++) {
			System.out.println("*****************************************************");
			
			className = Thread.currentThread().getStackTrace()[i].getClassName();//
			methodName = Thread.currentThread().getStackTrace()[i].getMethodName();//
			lineNumber = Thread.currentThread().getStackTrace()[i].getLineNumber();//
			System.out.println(className);
			System.out.println(methodName);
			System.out.println(lineNumber);
		}
		
	}

}
