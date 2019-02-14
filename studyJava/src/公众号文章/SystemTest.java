package 公众号文章;
/**
 * @ClassName： SystemTest
 * @Author: dhSu
 * @Description:你只会用System.out.println()吗
 * @Date:Created in 2019年2月12日
 */

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class SystemTest {
	
	//使用System.exit(1)
	@Test
	public void count() {
		for(int i=0;i<5;i++) {
			if (i > 3) {
				System.exit(1);
			}
			System.out.println("i=" + i);
		}
	}
	
	@Test
	public void test() {
		//当前至两小时前的间隔毫秒数
		long t = System.currentTimeMillis() - 2*3600*1000;
		//声明日期格式
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//两小时前日期加时间
		String dt = sd.format(new Date(t));
		System.out.println(dt);
	}
	
	@Test
	public void getSystemProties() {
		
		System.out.println("当前用户目录： " + System.getProperty("user.home") );
		System.out.println("当前系统用户： " + System.getProperty("user.name") );
		System.out.println("当前用户工作目录： " + System.getProperty("user.dir") );
	}
	
	@Test
	public void testErr() {
		String s = "xp";
		try {
			int i = Integer.parseInt(s);
			System.out.println(i);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	@Test
	public void testIn() throws Exception{
		//定义一个指向键盘的输入流
		InputStream in = System.in;
		//定义一个byte数组接收键盘输入的数据
		byte[] b = new byte[1024];
		//提示输入数据
		System.out.println("请输入数据：");
		//接收收据
		int len = in.read(b);
		System.out.println("输入的内容： " + new String(b,0,len));
		//关闭输入流
		in.close();
	}
}
