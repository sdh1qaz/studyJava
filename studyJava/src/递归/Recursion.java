package 递归;

import java.util.Stack;

/**
 * @ClassName： Recursion
 * @Author: dhSu
 * @Description: 递归打印斐波那契数列第100个数的值
 * @Date:Created in 2018年12月17日
 */

public class Recursion {
	
	public static void main(String[] args) {
		long start1 = System.currentTimeMillis();
		//打印斐波那契第100个数的值
		System.out.println(stack(50));
		long end1 = System.currentTimeMillis();
		System.out.println("用时：" + (end1-start1) + "毫秒");
		
		long start = System.currentTimeMillis();
		//打印斐波那契第100个数的值
		System.out.println(fxbo(50));
		long end = System.currentTimeMillis();
		System.out.println("用时：" + (end-start) + "毫秒");
	}
	
	//求斐波那契第n个数的值
	//1 1 2 3 5 8 13 .....
	public static long fxbo(int n) {
		//如果n=1，或n=2
		if(n == 1 || n == 2) {
			return 1;
		}
		return fxbo(n-1) + fxbo(n-2);
	}
	
	//堆栈法计算
	static long stack(int n){
		Stack<Long> stack=new Stack<Long>();
		stack.push(new Long(1));
		stack.push(new Long(1));
		int k=3;
		while(k<=n){
				Long F1=stack.pop();
				long f1=F1.longValue();
				Long F2=stack.pop();
				long f2=F2.longValue();
				Long t=new Long(f1+f2);
				stack.push(t);
				stack.push(F2);
				k++;
		}
		stack.pop();
		return stack.pop();
	}

}
