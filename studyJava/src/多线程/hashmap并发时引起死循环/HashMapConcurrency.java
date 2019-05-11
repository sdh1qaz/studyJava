package 多线程.hashmap并发时引起死循环;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

import org.junit.Test;

/**
 * @ClassName： HashMapConcurrency
 * @Author: dhSu
 * @Description:测试HashMap在并发时Entry链表形成环形数据结构，next节点不为空
 * 导致cpu 100%
 * @Date:Created in 2019年5月10日
 */

public class HashMapConcurrency {
	public static void main(String[] args) throws InterruptedException {
		final HashMap<String, String> map = new HashMap<String,String>(2);
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<10000;i++) {
					new Thread(new Runnable() {
						@Override
						public void run() {
							map.put(UUID.randomUUID().toString(), "");
						}
					}, "ftf" + i).start();
				}
			}
		},"ftf");
		t.start();
		t.join();
		System.out.println("线程ftf执行完毕");
		
	}
	
	@Test
	public void test() {
		System.out.println(1 << 4);
		System.out.println(Objects.hashCode("sudenghui"));
		System.out.println(Objects.hashCode("sudenghui"));
		System.out.println(Objects.hashCode(new String("sudenghui")));
		System.out.println(Objects.hashCode(null));
	}
	
	
	
	
	
	
}
