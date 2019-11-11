package 排序sort;

import java.util.Arrays;

/**
 * @ClassName： BubbleSort
 * @Author: dhSu
 * @Description:冒泡排序
 * @Date:Created in 2018年12月17日
 */

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = new int[] {1,4,2,9,7,3,8,5,100,56};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void bubbleSort(int[] arr) {
		int len = arr.length;
		for(int i=0;i<len;i++) {
			for(int j=0;j<len-i-1;j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}

}
