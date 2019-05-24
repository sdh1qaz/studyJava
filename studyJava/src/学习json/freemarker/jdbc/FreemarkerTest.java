package 学习json.freemarker.jdbc;

import java.util.Map;
import com.dhsu.json.CsfJSonUtils;
import org.junit.Test;

/**
 * @ClassName： FreemarkerTest
 * @Author: dhSu
 * @Description: 学习freemarker的使用
 * @Date:Created in 2019年5月24日
 */
class Student{
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

public class FreemarkerTest {
	
	@Test
	public void testFreemarker() {
		//json数据转化为字符串
		String jStu = "{\r\n" + 
				"    \"student\": {\r\n" + 
				"        \"name\": \"张三\",\r\n" + 
				"        \"age\": 20,\r\n" + 
				"        \"score\": {\r\n" + 
				"            \"语文\": \"90\",\r\n" + 
				"            \"数学\": \"100\",\r\n" + 
				"            \"英语\": \"80\"\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"}"; 
		//json串转化成bean对象
		Student s = CsfJSonUtils.jsonString2Bean(jStu, "student", Student.class);
		System.out.println(s.toString());
		
	}
}
