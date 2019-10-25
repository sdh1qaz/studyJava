package json的使用;

import java.io.Serializable;

/**
 * @ClassName： Student
 * 
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年10月24日
 */

public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -652117451169510878L;
	private String name;
	private int age;
	private String sex;

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
}
