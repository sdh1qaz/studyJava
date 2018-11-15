package com.dhsu.lang;
/**
 * @ClassName： RuntimeTest
 * @Author: dhSu
 * @Description:Runtime测试类，封装运行时环境
 * @Date:Created in 2018年11月15日
 */

public class RuntimeTest {
	/*Runtime类封装了运行时环境，不能实例化Runtime对象。但是，可以调用静态的Runtime.getRuntime()
	方法来获得对当前Runtime对象的引用。一旦获得了对当前Runtime对象的引用，就可以调用一些方法来控制Java
	虚拟机的状态和行为*/
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		System.out.println(runtime.totalMemory());
	}

}
