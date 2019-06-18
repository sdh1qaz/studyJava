package 多线程.并发工具类;
/**
 * @Description:CyclicBarrier提供了isBroken()方法用来了解阻塞的思安成是否被中断。
 * 这个类用来学习isBroken方法的使用
 */

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class IsBrokenTest {
	
	static CyclicBarrier c = new CyclicBarrier(2);
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					c.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		thread.start();
		//中断线程
		thread.interrupt();
		c.await();
		System.out.println(c.isBroken());
	}
}
