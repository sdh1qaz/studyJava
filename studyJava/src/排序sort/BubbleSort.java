package 排序sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] arr = new int[] {2,5,12,8,1,3,6,9,11};
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
