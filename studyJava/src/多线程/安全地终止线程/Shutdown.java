package 多线程.安全地终止线程;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName： Shutdown
 * @Author: dhSu
 * @Description: 终止线程的方法
 * @Date:Created in 2019年5月11日
 */

public class Shutdown {
	
	public static void main(String[] args) throws InterruptedException {
		Runner one = new Runner();
		Thread countThread = new Thread(one, "countThread");
		countThread.start();
		//睡眠1秒，main线程对CountThread进行中断，使CountThread能够感知中断而结束
		
		TimeUnit.SECONDS.sleep(1);
		countThread.interrupt();
		
		Runner two = new Runner();
		countThread = new Thread(two, "countThread");
		countThread.start();
		//睡眠1秒，main线程对Runner two进行取消，使countThread能够感知on为false而结束
		TimeUnit.SECONDS.sleep(1);
		two.cancel();
	}
	
	//该线程不断进行变量累加
	private static class Runner implements Runnable{
		private long i;
		private volatile boolean on = true;
		
		public void run() {
			while(on && !Thread.currentThread().isInterrupted()) {
				i ++;
			}
			System.out.println("Count i = " + i);
		}
		
		public void cancel() {
			on = false;
		}
	}
}
