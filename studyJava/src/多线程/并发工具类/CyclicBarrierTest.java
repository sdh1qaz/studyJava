package 多线程.并发工具类;
/**
 * @Description:同步屏障，java并发编程艺术p191
 * CyclicBarrier的字面意思是可循环使用的屏障。它要做的事情是，让一组线程到达一个屏障
 * （也可以叫同步点）时被阻塞，直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的
 * 线程才会继续运行。
 */

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	
	//参数2表示屏障拦截的线程数量，每个线程调用await方法告诉CyclicBarrier我已
	//到达了屏障，然后当前线程被阻塞，参数new A()用于在线程在到达屏障时，优先执行A线程
	static CyclicBarrier c = new CyclicBarrier(2,new A());
	
	//线程A
	static class A implements Runnable{
		@Override
		public void run(){
			System.out.println(3);
		}
	}
	
	public static void main(String[] args) {
		
		//线程1
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					c.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
				System.out.println(1);
			}
		}).start();
		
		//主线程
		try {
			c.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println(2);
	}
}
