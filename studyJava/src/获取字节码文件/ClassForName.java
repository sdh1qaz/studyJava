package 获取字节码文件;

import java.lang.reflect.Method;

/**
 * @ClassName： ClassForName
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年1月26日
 */

public class ClassForName {
	public static void main(String[] args) throws Exception {
		//1，根据类的全限定名获字节码文件
		Class<?> stu = Class.forName("获取字节码文件.Student");
		//2，根据字节码文件创建对象
		Student student = (Student)stu.newInstance();
		System.out.println(student.toString());
		//3,获取对象中的toString方法
		Method method = stu.getMethod("toString");
		//System.out.println(method.getName());
		//4,调用方法
		method.invoke(stu.newInstance());
	}
}
