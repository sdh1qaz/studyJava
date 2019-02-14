package 在类中引入单元测试;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @ClassName： JunitTest
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年2月12日
 */

public class JunitTest {
	
	//使用Junit做单元测试
	@Test
	public void sayHello() {
		System.out.println("你好");
	}
	
	@Test
	public void test() {
		assertThat("金刚葫芦娃", equalTo("金刚"));
	}

}
