package freemarker的使用;

import java.util.Map;

/**
 * @ClassName： Student
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年5月25日
 */

public class Student {
	private String name;
	private int age;
	private Map<String, String> score;
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
	public Map<String, String> getScore() {
		return score;
	}
	public void setScore(Map<String, String> score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
	}
	
}
