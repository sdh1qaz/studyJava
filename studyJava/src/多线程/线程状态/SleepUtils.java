package 多线程.线程状态;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName： SleepUtils
 * @Author: dhSu
 * @Description:封装休眠方法
 * @Date:Created in 2019年5月11日
 */

public class SleepUtils {
	
	public static final void seconds(long seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
