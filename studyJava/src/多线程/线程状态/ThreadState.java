package 多线程.线程状态;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName： ThreadState
 * @Author: dhSu
 * @Description: 线程状态
 * @Date:Created in 2019年5月11日
 */

public class ThreadState {
	
	//该线程不断地进行休眠
	static class TimeWaiting implements Runnable{
		@Override
		public void run() {
			while(true) {
				SleepUtils.seconds(100);
			}
		}
	}
	
	//该线程在Waiting.class实例上等待
	static class Waiting implements Runnable{
		@Override
		public void run() {
			while(true) {
				synchronized (Waiting.class) {
					try {
						Waiting.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	//该线程在Blocked.class实例上加锁后，不会释放该锁
	static class Blocked implements Runnable{
		public void run() {
			synchronized (Blocked.class) {
				while(true) {
					SleepUtils.seconds(100);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new Thread(new TimeWaiting(), "TimeWaitingThread").start();
		new Thread(new Waiting(), "WaitingThread").start();
		new Thread(new Blocked(), "BlockedThread-1").start();
		new Thread(new Blocked(), "BlockedThread-2").start();
	}
}
