package 多线程.并发工具类;
/**
 * @ClassName： CountDownLatchTest
 * @Author: dhSu
 * @Description: 等待多线程完成的ConuntDownLatch工具类学习
 * @Date:Created in 2019年6月18日
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
	
	static CountDownLatch c = new CountDownLatch(2);
	
	public static void main(String[] args) throws InterruptedException {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println(1);
					c.countDown();
					Thread.sleep(2000);
					System.out.println(2);
					c.countDown();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}).start();
		
		c.await(1,TimeUnit.SECONDS);
		System.out.println(3);
	}
}
