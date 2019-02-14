package 使用反射操作对象中的属性;

import java.lang.reflect.Field;

/**
 * @ClassName： Test
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年2月14日
 */

class Student{
	public String name;//姓名
	private String sex;//性别
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}

public class Test {
	
	public void ff() throws Exception{
		//获取类Student的字节码
		Class<Student> c1 = Student.class;
		//获取姓名name属性
		Field f1 = c1.getField("name");
		//利用反射创造对象
		Student s1 = (Student)c1.newInstance();
		//给对s1的属性name赋值
		f1.set(s1, "东方不败");
		//打印对象f1的姓名
		System.out.println(s1.name);
	}
	
	public static void main(String[] args) throws Exception{
		//获取类Student的字节码
		Class<Student> c1 = Student.class;
		//获取姓名name属性
		Field f2 = c1.getDeclaredField("sex");
		//去除对象s1的属性sex的私有性
		f2.setAccessible(true);
		//利用反射创造对象
		Student s1 = (Student)c1.newInstance();
		//给对s1的属性name赋值
		f2.set(s1, "女");
		//打印对象f1的姓名
		System.out.println(s1.getSex());
	}
	
}
