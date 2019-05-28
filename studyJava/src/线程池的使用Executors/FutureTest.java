package 线程池的使用Executors;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @ClassName： FutureTest
 * @Author: dhSu
 * @Description: Future可以获取callable接口中call方法返回的值
 * @Date:Created in 2019年5月28日
 */

public class FutureTest {
	
	public static class Task implements Callable<String>{
		@Override
		public String call() throws Exception{
			System.out.println(Thread.currentThread().getName() + "ah");
			return "something";
		}
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		//结果列表
		List<Future<String>> results = new ArrayList<Future<String>>();
		//线程池
		ExecutorService es = Executors.newCachedThreadPool();
		
		//提交任务
		for(int i=0;i<10;i++) {
			results.add(es.submit(new Task()));
		}
		
		//获取结果
		for(Future<String> result : results) {
			System.out.println(Thread.currentThread().getName() + ": " + result.get());
		}
	}
}
