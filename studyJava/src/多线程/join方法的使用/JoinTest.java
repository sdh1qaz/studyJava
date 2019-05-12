package 多线程.join方法的使用;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName： JoinTest
 * @Author: dhSu
 * @Description: 学习join方法的使用
 * @Date:Created in 2019年5月12日
 */

public class JoinTest {
	
	public static void main(String[] args) throws InterruptedException {
		//获取当前线程
		Thread previous = Thread.currentThread();
		//每一个线程拥有前一个线程的引用，需等待前一个线程终止，才能从等待中返回
		for(int i = 0;i < 10; i++) {
			Thread thread = new Thread(new Domino(previous),String.valueOf(i));
			thread.start();
			previous = thread;
		}
		TimeUnit.SECONDS.sleep(5);
		System.out.println(Thread.currentThread().getName() + " terminate.");
	}
	
	static class Domino implements Runnable{
		private Thread thread;
		public Domino(Thread thread) {
			this.thread = thread;
		}
		
		public void run() {
			try {
				thread.join();
				System.out.println(Thread.currentThread().getName() + " 开始运行.");
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " terminate.");
		}
	}
}
