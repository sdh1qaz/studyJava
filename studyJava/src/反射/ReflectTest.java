package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * @ClassName： ReflectTest
 * @Author: dhSu
 * @Description: 根据方法名去调用具体的方法
 * @Date:Created in 2019年2月11日
 */

public class ReflectTest {
	private String name;
	
	public ReflectTest() {};
	public ReflectTest(String name) {
		super();
		this.name = name;
	}

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
	
	//利用反射生成对象
	@Test
	public void getInstance() throws Exception {
		//获取ReflectTest的字节码
		Class<ReflectTest> cla = ReflectTest.class;
		//获取构造方法
		Constructor<ReflectTest> constructor = cla.getConstructor();
		//打印构造方法名字
		System.out.println(constructor.getName());
	}
	
	public static void main(String[] args) throws Exception {
		invoke("sayHelloToPHP");
	}
}
