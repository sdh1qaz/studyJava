package 学习validattor注解;

import javax.validation.Valid;

/**
 * @ClassName： LearnValidator
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年4月2日
 */

public class LearnValidator {
	public static void print(@Valid Student s) {
		System.out.println(s.toString());
	}
	public static void main(String[] args) {
		Student s = new Student();
		s.setAge(12);
		print(s);
	}
}
