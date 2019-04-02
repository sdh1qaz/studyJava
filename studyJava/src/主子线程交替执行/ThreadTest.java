package 主子线程交替执行;

import java.util.Hashtable;

/**
 * 1.程序开始时子线程和主线程都有机会运行，假设是主线程优先运行。 2.i = 0，开始调用mainThread方法，由于flag =
 * true，会执行wait方法， 当前线程挂起等待。 3.开始行子线程，调用subThread方法，打印10个信息，从i=0,j=0到j=9。
 * flag的值变为flase，唤醒主线程。如果这个时候线程被切换到子进程，会执行wait方法，挂起子线程。
 * 4.开始执行主线程，调用mainThread方法，打印10个信息，从i=0,j=0到j=5。
 * flag的值变为true，唤醒子线程。如果这个时候线程被切换到主进程，会执行wait方法，挂起主线程。 5.如此循环50次。
 */
public class ThreadTest {
	public static void main(String[] args) {
		//new ThreadTest().init();
		Hashtable<String, String> ht = new Hashtable<>();
		ht.put(null, "nihao");
	}

	public void init() {
		final Business business = new Business();

		// 子线程
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					business.subThread(i);
				}
			}
		}).start();

		// 主线程
		for (int i = 0; i < 50; i++) {
			business.mainThread(i);
		}
	}

	private class Business {
		// 定义了控制该谁执行的一个信号灯,为true时
		boolean flag = true;

		// 主线程执行的内容
		public synchronized void mainThread(int i) {
			if (flag) {
				try {
					this.wait();// 线程等待，直到被唤醒（调用notify方法）
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 0; j < 5; j++) {
				System.out.println(Thread.currentThread().getName() + "-总体循环第：" + i + "次" + ",循环计数：j=" + j);
			}
			flag = true;
			this.notify();
		}

		// 子线程执行的内容
		public synchronized void subThread(int i) {
			if (!flag) {
				try {
					this.wait();// 线程等待，直到被唤醒（调用notify方法）
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 0; j < 10; j++) {
				System.out.println(Thread.currentThread().getName() + "-总体循环第：" + i + "次" + ",循环计数：j=" + j);
			}
			flag = false;
			this.notify();
		}
	}
}