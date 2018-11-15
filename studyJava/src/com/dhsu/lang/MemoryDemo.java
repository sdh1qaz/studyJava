package com.dhsu.lang;
/**
 * @ClassName： MemoryDemo
 * @Author: dhSu
 * @Description: 用Runtime实现内存管理
 * @Date:Created in 2018年11月15日
 */

public class MemoryDemo {
	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		long mem1,mem2;
		Integer someInts[] = new Integer[1000];
		
		System.out.println("Total memory is:" + r.totalMemory());
		mem1 = r.freeMemory();
		System.out.println("Initial memory is:" + mem1);
		r.gc();//运行垃圾回收器
		mem1 = r.freeMemory();
		System.out.println("free memory after garbage collection:" + mem1);
		
		//执行对象分配操作
		for(int i=0;i<1000;i++) {
			someInts[i] = new Integer(i);
		}
		mem2 = r.freeMemory();//获取当前可用内存
		System.out.println("free memory after allocation:" + mem2);//执行对象分配操作后的可用内存
		System.out.println("memory used by allocation :" + (mem1 - mem2));//分配对象使用的内存
		
		//discard Integers
		for(int i=0;i<1000;i++)
			someInts[i] = null;
		r.gc();//运行垃圾回收器
		System.out.println("free memory after collecting discarded Integers:" + mem2);
	}
}
