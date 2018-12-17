package com.dhsu.algorithm.queue;

import java.util.Arrays;

/**
 * @ClassName： Queue
 * @Author: dhSu
 * @Description: 队列,先进先出，后进后出
 * @Date:Created in 2018年12月17日
 */

public class Queue {
	private int[] arr;
	
	public Queue(int[] arr) {
		this.arr = arr;
	}
	public static void main(String[] args) {
		int[] arr = new int[0];
		//实例化一个队列
		Queue queue = new Queue(arr);
		System.out.println("初始队列：" + Arrays.toString(arr));
		//入队
		queue.push(1);
		queue.push(2);
		queue.push(3);
		
		//出队
		queue.pop();
		queue.pop();
		queue.pop();
	}
	
	//入队
	public void push(int num) {
		//原来数组的长度
		int len = arr.length;
		//定义一个新数组，长度比原来数组多1
		int[] arrNew = new int[len+1];
		for(int i=0;i<len;i++) {
			arrNew[i] = arr[i];
		}
		arrNew[len] = num;
		arr = arrNew;
		System.out.println(num + "入队，当前队列：" + Arrays.toString(arr));
	}
	
	//出队
	public void pop() {
		//获取原来数组长度
		int len = arr.length;
		if(len < 1) {
			System.out.println("队列为空");
			return;
		}
		//定义一个新数组，比原来数组小1
		int[] arrNew = new int[len-1];
		for(int i=0;i<len-1;i++) {
			arrNew[i] = arr[i+1];
		}
		//出队数字
		int out = arr[0];
		arr = arrNew;
		System.out.println(out + "出队，当前队列：" + Arrays.toString(arr));
	}
	

}
