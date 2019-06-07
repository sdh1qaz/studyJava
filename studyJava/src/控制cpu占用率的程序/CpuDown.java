package 控制cpu占用率的程序;

/**
 * @ClassName： CpuDown
 * @Author: dhSu
 * @Description: cpu100%的java程序
 * @Date:Created in 2019年5月31日
 */

public class CpuDown {
	//定义线程
	static class Run implements Runnable{
		@Override
		public void run() {
			while (true) {
			}
		}
	}
	
	//无限启动线程，直到cpu占满
	public static void main(String[] args) {
		while(true) {
			new Thread(new Run()).start();
		}
	}
}
