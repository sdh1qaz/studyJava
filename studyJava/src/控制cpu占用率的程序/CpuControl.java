package 控制cpu占用率的程序;

/**
 * @ClassName： CpuOut
 * @Author: dhSu
 * @Description:控制cpu利用率在10%
 * @Date:Created in 2019年5月31日
 */

public class CpuControl {
	
	static class Run implements Runnable{
		@Override
		public void run() {
			long busyTime = 10;
			long idleTime = 90;
			while (true) {
				//获取当前的系统时间毫秒数
				long nowSys = System.currentTimeMillis();
				//cpu忙5毫秒
				while ((System.currentTimeMillis() - nowSys) <= busyTime) {
				}
				
				try {
					//cpu闲5毫秒
					Thread.sleep(idleTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		for(int i=0;i<15;i++) {
			new Thread(new Run()).start();
		}
	}
}
