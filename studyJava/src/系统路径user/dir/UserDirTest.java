package 系统路径user.dir;

import org.junit.Test;

/**
 * @ClassName： UserDirTest
 * @Author: dhSu
 * @Description: 测试windows的user.dir
 * @Date:Created in 2019年6月6日
 */

public class UserDirTest {
	
	@Test
	public void testUserDir() {
		System.out.println("user.dir:" + System.getProperty("user.dir"));
		System.out.println("env_user.dir:" + System.getenv("user.dir"));
	}
}
