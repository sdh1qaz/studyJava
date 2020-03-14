package timetask实现定时任务;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimer extends TimerTask{
	public void run(){
        //执行任务
		System.out.println("定时任务： " + new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒").format(new Date()));
    }
	
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new MyTimer(), 0, 5*1000);
	}
}
