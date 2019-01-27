package 获取字节码文件;
/**
 * @ClassName： Student
 * @Author: dhSu
 * @Description:获取字节码文件.Student
 * @Date:Created in 2019年1月26日
 */

public class Student {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
		
	}
	
	public void dayin() {
		System.out.println("ni");
	}
	
}
