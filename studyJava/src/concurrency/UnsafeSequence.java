package concurrency;
/**
 * @ClassName： UnsafeSequence
 * @Author: dhSu
 * @Description:非线程安全的数值序列发生器
 * @Date:Created in 2018年4月1日
 */

public class UnsafeSequence {
     private int value;
     
     /** 返回一个唯一的数值 */
     public synchronized int getValue() {
    	 return value ++;
     }
}
