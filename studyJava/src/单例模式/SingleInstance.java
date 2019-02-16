package 单例模式;

import org.junit.Test;

/**
 * @ClassName： SingleInstance
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年2月16日
 */

public class SingleInstance {
	//将构造方法私有化，不让别人调用
	private SingleInstance() {}
	
	//创建一个对象（单例）
	private static SingleInstance single = new SingleInstance();
	//提供一个刚发，让别人都获取你创建好的单例对象 single
	public static SingleInstance getSingle() {
		return single;
	}
	
	public static void main(String[] args) {
		SingleInstance s1 = SingleInstance.getSingle();
		SingleInstance s2 = SingleInstance.getSingle();
		System.out.println("s1和s2是否指向同一个对象？ " + (s1 == s2));
	}
}


