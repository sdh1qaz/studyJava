package com.dhsu.lang;
/**
 * @ClassName： Execdemo
 * @Author: dhSu
 * @Description: 用Runtime对象打开windows记事本
 * @Date:Created in 2018年11月15日
 */

public class Execdemo {
	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		Process p = null;
		
		try {
			p = r.exec("notepad");
			p.waitFor();//程序等待，直至打开的记事本进程结束
		}catch(Exception e) {
			System.out.println("Error executing notepad");
		}
		//打印出记事本进程结束时 返回值
		System.out.println("Notepad returned： " + p.exitValue());
	}

}
