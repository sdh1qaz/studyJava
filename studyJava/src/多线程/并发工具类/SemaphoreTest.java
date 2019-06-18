package 多线程.并发工具类;
/**
 * @Description:控制并发线程数的工具类
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	
	//线程数
	private static final int THREAD_COUNT = 30;
	//线程池
	private static ExecutorService threadpool = Executors.newFixedThreadPool(THREAD_COUNT);
	
	//信号量
	private static Semaphore s = new Semaphore(10);
	
	public static void main(String[] args) {
		for(int i=0;i<THREAD_COUNT;i++) {
			threadpool.execute(new Runnable() {
				
				@Override
				public void run() {
					try {
						s.acquire();
						System.out.println("save data");
						s.release();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
}
