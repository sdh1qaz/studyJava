package 多线程.线程通信;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import 多线程.线程状态.SleepUtils;

/**
 * @ClassName： WaitNotify
 * @Author: dhSu n
 * @Description: 等待通知机制
 * @Date:Created in 2019年5月12日
 */

public class WaitNotify {
	
	static boolean flag = true;
	static Object lock = new Object();
	
	static class Wait implements Runnable{
		public void run() {
			//加锁，拥有lock的Monitor
			synchronized (lock) {
				//条件不满足时，继续wait，同时释放了lock的锁
				while(flag) {
					System.out.println(Thread.currentThread() + "flag is true,wait @ " +
							new SimpleDateFormat("HH:mm:ss").format(new Date()));
								try {
									//调用wait方法的线程进入Waiting状态，等另外的线程通知或被中断才会返回，
									//调用wait方法后，会释放对象的锁
									lock.wait();
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				}
				//条件满足时，完成工作
				System.out.println(Thread.currentThread() + "flag is false,running @ " + 
				new SimpleDateFormat("HH:mm:ss").format(new Date()));
			}
		}
	}
	
	static class Notify implements Runnable{
		public void run() {
			//加锁，拥有lock的Monitor
			synchronized (lock) {
				//获取lock的锁，然后进行通知，通知时不会释放lock的锁，
				//直到当前线程释放了lock后，WaitThread才能从wait方法中返回
				System.out.println(Thread.currentThread() + "hold lock,notify @ " + 
				new SimpleDateFormat("HH:mm:ss").format(new Date()));
				lock.notifyAll();
				flag = false;
				SleepUtils.seconds(10);
			}
			//再次加锁
			synchronized (lock) {
				System.out.println(Thread.currentThread() + "hold lock again,sleep @ " +
			new SimpleDateFormat("HH:mm:ss").format(new Date()));
				SleepUtils.seconds(5);
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread waitThread = new Thread(new Wait(),"WaitThread");
		waitThread.start();
		TimeUnit.SECONDS.sleep(1);
		Thread notifyThread = new Thread(new Notify(),"NotifyThread");
		notifyThread.start();
	}
}
