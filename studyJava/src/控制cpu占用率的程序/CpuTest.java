package 控制cpu占用率的程序;

//参考：https://blog.csdn.net/godloveleo9527/article/details/46665425
public class CpuTest extends Thread {

	public static void main(String[] args) {
		
		/* 启动四个线程，电脑逻辑cpu为4个，一个线程无限循环
		cpu的占用率为25%，四个线程就是100%。
		逻辑cpu个数为l，死循环线程的个数为t，cpu占用率为p，它们之间的关系：
		etc：l=4，t=1，p=25%，p = t / l * 100%  
		已知l=4，p=0.1，t=？，t=p*l=0.1*4=0.4 
		0.4个线程怎样实现？只能设置线程在一个时间单位(1)里的忙时比（忙时除以总时）b_i=0.4了*/
		
		/*cpu逻辑逻辑核l=43，占比p=0.1，需要的死循环线程数t=p*l=0.1*43=4.3*/
		/*这里开启t_start=5个线程，忙时比（忙时除以总时）b_i=t/t_start=4.3/5=0.86*/
		new Thread(new CpuOccupy()).start();
		/*new Thread(new CpuOccupy()).start();
		new Thread(new CpuOccupy()).start();
		new Thread(new CpuOccupy()).start();
		new Thread(new CpuOccupy()).start();*/
	}
	
	//定义cpu占用内部类，作用是定义线程
	static class CpuOccupy implements Runnable{

		@Override
		public void run() {
			//忙时比（忙时除以总时）=busyTime/(busyTime+idleTime)
			//忙时
			long busyTime = 100;
			//闲时 idleTime=（busyTime/b_i）-busyTime=100/0.86-100=16
			long idleTime = 25;
			while (true) {
				//获取当前的系统时间毫秒数
				long nowSys = System.currentTimeMillis();
				//cpu忙 busyTime 毫秒
				while ((System.currentTimeMillis() - nowSys) <= busyTime) {
				}
				
				try {
					//cpu闲 idleTime 毫秒
					Thread.sleep(idleTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
