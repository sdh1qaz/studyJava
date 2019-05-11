package 多线程.线程优先级;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName： Priority
 * @Author: dhSu
 * @Description:学习线程优先级
 * @Date:Created in 2019年5月11日
 */

public class Priority {
	
	private static volatile boolean notstart = true;
	private static volatile boolean notend = true;
	
	public static void main(String[] args) throws InterruptedException {
		//线程对象列表
		List<Job> jobs = new ArrayList<Job>();
		for(int i = 0;i < 10;i++) {
			//线程优先级
			int priority = i <5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
			//定义Runnable对象
			Job job = new Job(priority);
			//线程对象添加到线程列表
			jobs.add(job);
			//定义线程对象
			Thread thread = new Thread(job, "Thread:" + i);
			//线程设置优先级
			thread.setPriority(priority);
			//线程启动
			thread.start();
		}
		notstart = false;
		TimeUnit.SECONDS.sleep(10);
		notend = false;
		
		for(Job job : jobs) {
			System.out.println("Job Priority:" + job.priority 
					+ ",Count:" + job.jobCount);
		}
	}
	
	static class Job implements Runnable{
		//线程的优先级
		private int priority;
		private long jobCount;
		
		public Job(int priority) {
			this.priority = priority;
		}
		//线程真正执行的部分
		public void run() {
			while(notstart) {
				//让优先级更高的线程执行
				Thread.yield();
			}
			while(notend) {
				Thread.yield();
				jobCount ++;
			}
		}
	}
}
