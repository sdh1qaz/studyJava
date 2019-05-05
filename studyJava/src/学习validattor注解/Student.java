package 学习validattor注解;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @ClassName： Student
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年4月2日
 */

public class Student implements Serializable{
	private static final long serialVersionUID = 872902124436369536L;
	@NotEmpty(message="name不能为空")
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
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
}
