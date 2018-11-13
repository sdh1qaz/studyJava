package com.dhsu.concurrency;
/**
 * @ClassName： ThreadTest
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2018年7月16日
 */

public class ThreadTest {
	static int count=0;
    public static void main(String[] args) {
    	
    	for(int i=0;i<1000;i++) {
    		
    		new Thread("thread-01") {
    			public void run() {
    				synchronized (this) {
        				count +=1;
        				System.out.println(Thread.currentThread().getName() + " is running , it's state is: " + Thread.currentThread().getState() + " , count=" + count);
					}

    			}
    		}.start();
    		
    		new Thread("thread-02") {
    			public void run() {
    				synchronized (this) {
    					count -=1;
    					System.out.println(Thread.currentThread().getName() + " is running , it's state is: " + Thread.currentThread().getState() + " , count=" + count);
					}
    			}
    		}.start();
    	}
		
	}
}
