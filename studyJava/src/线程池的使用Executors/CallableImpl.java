package 线程池的使用Executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName： CallableImpl
 * 
 * @Author: dhSu
 * @Description:测试callable接口的特性
 * @Date:Created in 2019年5月28日
 */
// 参考：https://www.cnblogs.com/frinder6/p/5507082.html
public class CallableImpl implements Callable<String>{
	
	public CallableImpl(String acceptStr) {
		this.acceptStr = acceptStr;
	}

	private String acceptStr;

	@Override
	public String call() throws Exception {
		// 任务阻塞 1 秒
		Thread.sleep(1000);
		return this.acceptStr + " append some chars and return it!";
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		Callable<String> callable = new CallableImpl("my callable test!");
		FutureTask<String> task = new FutureTask<>(callable);
		long beginTime = System.currentTimeMillis();
		// 创建线程
		new Thread(task).start();
		// 调用get()阻塞主线程，反之，线程不会阻塞
		String result = task.get();
		long endTime = System.currentTimeMillis();
		System.out.println("hello : " + result);
		System.out.println("cast : " + (endTime - beginTime) / 1000 + " second!");
	}
}
