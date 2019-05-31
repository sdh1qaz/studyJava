package 一段cpu百分百的java程序;

import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * @ClassName： CpuOut
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年5月31日
 */

public class CpuControl {
	
	static class Run implements Runnable{
		@Override
		public void run() {
			/*long busyTime = 5;
			long idleTime = 5;*/
			while (true) {
				//long nowSys = System.currentTimeMillis();
				/*while ((System.currentTimeMillis() - nowSys) <= busyTime) {
				}*/
				/*try {
					Thread.sleep(idleTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}*/
			}
		}
	}
	
	public static void main(String[] args) {
		/*while(true) {
			new Thread(new Run()).start();
		}*/
		
		for(int i=0;i<15;i++) {
			new Thread(new Run()).start();
		}
	}
}
