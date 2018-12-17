package com.dhsu.algorithm.stack;

/**
 * @ClassName： Stack
 * @Author: dhSu
 * @Description: 栈
 * @Date:Created in 2018年12月17日
 */

public class Stack {
	private int[] arr;
	public Stack(int[] arr) {
		this.arr = arr;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2};
		Stack stack = new Stack(arr);
		//压入数据
		stack.push(5);
		stack.push(6);
		stack.push(7);
		
		//弹出数据
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		
	}
	//入栈
	public void push(int num) {
		int len = arr.length;
		int[] arrNew = new int[len+1];
		arrNew[0] = num;
		for(int i=1;i<len+1;i++) {
			arrNew[i] = arr[i-1];
		}
		System.out.println("压入：" + num);
		arr = arrNew;
	}
	
	//出栈
	public void pop() {
		int len = arr.length;
		int[] arrNew = new int[len-1];
		System.out.println("弹出：" + arr[0]);
		for(int i=1;i<len;i++) {
			arrNew[i-1] = arr[i];
		}
		arr = arrNew;
	}

}















