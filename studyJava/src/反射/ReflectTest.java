package 反射;

import java.lang.reflect.Method;

/**
 * @ClassName： ReflectTest
 * @Author: dhSu
 * @Description: 根据方法名去调用具体的方法
 * @Date:Created in 2019年2月11日
 */

public class ReflectTest {
	public void sayHelloToJava() {
		System.out.println("hello java");
	}
	
	public void sayHelloToPHP() {
		System.out.println("hello php");
	}
	
	public void sayHelloToC(){
		System.out.println("hello C");
	}
	
	public static void invoke(String medName) throws Exception {
		//获取ReflectTest的字节码
		Class<ReflectTest> cla = ReflectTest.class;
		//获取名为medName的方法
		Method method = cla.getMethod(medName);
		ReflectTest r = new ReflectTest();
		//调用该方法
		method.invoke(r);
	}
	
	public static void main(String[] args) throws Exception {
		invoke("sayHelloToPHP");
	}
}
