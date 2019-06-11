package 控制cpu占用率的程序;

/**
 * @Author: 苏登辉
 * @Description:控制cpu占比的程序，运行：java Provider 0.1 48 200
 * 0.1是需要的cpu占用比，48是cpu逻辑核数，200是线程时间单位毫秒数（可微调）
 * @Date:Created in 2019年6月11日
 */

public class Provider extends Thread {
	//参考：https://blog.csdn.net/godloveleo9527/article/details/46665425
	//需要输入CPU逻辑核数，然后再输入总时毫秒数来微调
	public static void main(String[] args) {
		
		/* 启动四个线程，电脑逻辑cpu为4个，一个线程无限循环
		cpu的占用率为25%，四个线程就是100%。
		逻辑cpu个数为l，死循环线程的个数为t，cpu占用率为p，它们之间的关系：
		etc：l=4，t=1，p=25%，p = t / l * 100%  
		已知l=4，p=0.1，t=？，t=p*l=0.1*4=0.4 
		0.4个线程怎样实现？只能设置线程在一个时间单位(1)里的忙时比（忙时除以总时）b_i=0.4了*/
		
		/*cpu逻辑逻辑核l=48，占比p=0.1，需要的死循环线程数t=p*l=0.1*48=4.8*/
		/*这里开启t_start=10个线程，忙时比（忙时除以总时）b_i=t/t_start=4.8/10=0.48*/
		/*从键盘传入逻辑核数l*/
		/*Scanner sc = new Scanner(System.in);*/
		/*sc.close();*/
		System.out.println("需要占用的cpu的百分比(如10%就是输入0.1)：" + args[0]);
		System.out.println("cpu逻辑核数：" + args[1]);
		System.out.println("线程单位时长ms：" + args[2]);
		double p = Double.parseDouble(args[0]);
		double b_i = Integer.parseInt(args[1]) * 0.1 * p;
		int unit = Integer.parseInt(args[2]);
		
		System.out.println("程序开始运行.....");
		for(int i=0;i<10;i++) {
			new Thread(new CpuOccupy(b_i,unit)).start();
		}
	}
	
	//定义cpu占用内部类，作用是定义线程
	static class CpuOccupy implements Runnable{
		//忙时比（忙时除以总时）
		double b_i;
		//总时
		int unit;
		
		public CpuOccupy(double b_i,int unit) {
			this.b_i = b_i;
			this.unit = unit;
		}

		@Override
		public void run() {
			//忙时比（忙时除以总时）=busyTime/(busyTime+idleTime)
			//忙时
			long busyTime = (long) (unit * b_i);
			//闲时
			long idleTime = (long) (unit - unit * b_i);
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
