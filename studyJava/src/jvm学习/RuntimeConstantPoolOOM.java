package jvm学习;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName： RuntimeConstantPoolOOM
 * @Author: dhSu
 * @Description: 运行时常量池导致的内存溢出异常，jdk7以上不会出现异常
 * @Date:Created in 2019年6月3日
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 */

public class RuntimeConstantPoolOOM {
	
	public static void main(String[] args) {
		//使用List来保持着常量池引用，避免Full GC回收常量池行为
		List<String> list = new ArrayList<>();
		//10M的PermSize在integer范围内足够产生OOM了
		int i = 0;
		
		//inetrn方法的作用：如果字符串常量池中已经包含一个等于此String对象的
		//字符串，则返回代表池中这个字符串的String对象；否则，将此String对象
		//包含的字符串添加到常量池中，并返回此String对象的引用
		while(true) {
			list.add(String.valueOf(i++).intern());
		}
	}
}
