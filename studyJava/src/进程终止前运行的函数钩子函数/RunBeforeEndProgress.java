package 进程终止前运行的函数钩子函数;
/**
 * @ClassName： RunBeforeEndProgress
 * @Author: dhSu
 * @Description: 学习钩子函数的使用，在进程终止前运行
 * @Date:Created in 2019年6月17日
 */

public class RunBeforeEndProgress {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("开始执行程序");
		
		//进程终止前运行的内容
		Runtime.getRuntime().addShutdownHook(new Thread() {
			
			@Override
			public void run() {
				System.out.println("do shutdownHook.......");
			}
		});
		
		Thread.sleep(12000);
	}
}
