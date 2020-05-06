package 并发concurrency;
/**
 * @ClassName： MyThread
 * @Author: dhSu
 * @Description:线程测试类
 * @Date:Created in 2018年4月1日
 */

public class MyThread implements Runnable{  
    private UnsafeSequence unsafeSequence;
    
    public MyThread(UnsafeSequence unsafeSequence) {
    	this.unsafeSequence = unsafeSequence;
    }
    
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ":   " + unsafeSequence.getValue());
	}
	
	public static void main(String[] args) {
		UnsafeSequence unsafeSequence = new UnsafeSequence();
		for(int i = 0;i <10;i++) {
			Thread thread = new Thread(new MyThread(unsafeSequence), "thread"+i);
			thread.start();
		}
	}
}
