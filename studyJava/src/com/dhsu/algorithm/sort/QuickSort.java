package com.dhsu.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName： QuickSort
 * @Author: dhSu
 * @Description:快速排序
 * @Date:Created in 2018年12月21日
 */

public class QuickSort {
	public static void main(String[] args) {
		//初始化一个数组
		int[] arr = new int[30];
		//为数组随机复制
		Random random = new Random();
		for(int i = 0;i < arr.length;i++) {
			arr[i] = random.nextInt(1000);
		}
		System.out.println(Arrays.toString(arr));
		long startTime = System.currentTimeMillis();
		try {
			quickSort(arr,0,arr.length-1);
		} catch (StackOverflowError e) {
			e.printStackTrace();
		}
		System.out.println(Arrays.toString(arr));
		long endTime = System.currentTimeMillis();
		System.out.println("排序时间:" + (startTime - endTime) + "毫秒");
	}
	
	//快速排序方法
	public static void quickSort(int[] arr,int start,int end) {
		if(start < end) {
			//低坐标
			int low = start;
			//高坐标
			int high = end;
			//保存第一个数为基准
			int strd = arr[start];
			while(low < high) {
				//如果大于标准数，则将下标左移1位
				while(low < high && arr[high] > strd) {
					high--;
				}
				//小于标准数
				arr[low] = arr[high];
				//如果小于标准数，将下标右移1位
				while(low < high && arr[low] <= strd) {
					low++;
				}
				arr[high] = arr[low];
			}
			//低坐标等于高坐标时
			arr[low] = strd;
			//此时数组被分成两段，一段都比标准数小，一段都比标准数大，分别递归
			quickSort(arr, start, low);
			quickSort(arr, low+1, end);
		}
	}
}
