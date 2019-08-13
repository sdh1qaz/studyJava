package 不安全的HsahMap;

public class ThreadTest {
	public static void main(String[] args) {
		new ThreadTest().init();
	}
	
	public void init() {
		final Business business = new Business();
		
		//子线程
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					business.subThread(i);
				}
			}
		}).start();
		
		//主线程
		for (int i = 0; i < 50; i++) {
			business.mainThread(i);
		}
	}

	private class Business {
		//定义了控制该谁执行的一个信号灯,为true时
		boolean flag = true;

		//主线程执行的内容
		public synchronized void mainThread(int i) {
			if (flag) {
				try {
					this.wait();//线程等待，直到被唤醒（调用notify方法）
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
		
		//子线程执行的内容
		public synchronized void subThread(int i) {
			if (!flag) {
				try {
					this.wait();//线程等待，直到被唤醒（调用notify方法）
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