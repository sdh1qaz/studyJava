package com.dhsu.queue;
/**
 * �ο���http://blog.csdn.net/lzy_lizhiyang/article/details/48311925
 * @author Administrator
 *
 */
import java.util.concurrent.BlockingQueue;  
import java.util.concurrent.Executors;  
import java.util.concurrent.LinkedBlockingQueue;  
import java.util.concurrent.ScheduledExecutorService;  
import java.util.concurrent.TimeUnit;  
  
public class UserTask {  
    //���д�С  
    private final int QUEUE_LENGTH = 10000*10;  
    //�����ڴ����������  
    private BlockingQueue<String> queue = new LinkedBlockingQueue<String>(QUEUE_LENGTH);  
    //�����ƻ�����ִ����  
    private ScheduledExecutorService es = Executors.newScheduledThreadPool(1);  
  
    /** 
     * ���캯����ִ��execute���� 
     */  
    public UserTask() {  
        execute();  
    }  
      
    /** 
     * �����Ϣ�������� 
     * @param content 
     */  
    public void addQueue(String content) {  
        queue.add(content);  
    }  
      
    /** 
     * ��ʼ��ִ�� 
     */  
    public void execute() {  
        //ÿһ����ִ��һ��  
        es.scheduleWithFixedDelay(new Runnable(){  
            public void run() {  
                try {  
                    String content = queue.take();  
                    //��������е���Ϣ����������  
                    System.out.println(content);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }  
              
        }, 0, 1, TimeUnit.MINUTES);  
    }  
}  