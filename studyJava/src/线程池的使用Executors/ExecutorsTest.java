package 线程池的使用Executors;
/**
 * @ClassName： ExecutorsTest
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年5月28日
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest {

	private ExecutorService executor = Executors.newCachedThreadPool();
	
	//一个费时5秒的操作
	void doSomthing() {
		try {
			System.out.println(Thread.currentThread().getName() + "操作开始");
			Thread.sleep(1000*5);
			System.out.println(Thread.currentThread().getName() + "操作完成");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ExecutorsTest executorsTest = new ExecutorsTest();
		for(int i=0;i<10;i++) {
			executorsTest.executor.submit(new Runnable() {
				
				@Override
				public void run() {
					executorsTest.doSomthing();
				}
			});
		}
		
	}
	
	
}
