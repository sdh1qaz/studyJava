package 栈;

/**
 * @ClassName： Stack
 * @Author: dhSu
 * @Description: 栈
 */

public class Stack<T> {
	private Object[] tArr;//存放栈元素
	private int top;//栈顶
	private int max;//栈容量
	
	public Object[] gettArr() {
		return tArr;
	}

	public void settArr(Object[] tArr) {
		this.tArr = tArr;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	//构造一个栈
	public Stack(int max) {
		super();
		this.max = max;
		this.tArr = new Object[max];
		this.top = -1;//栈顶默认-1
	}
	
	//入栈
	public boolean push(T t) {
		//栈满了，入栈失败
		if (top == max - 1) {
			System.out.println("满了");
			return false;
		}
		if (top != -1) {
			for(int i=0;i<top+1;i++) {
				tArr[top+1-i] = tArr[top-i];
			}
		}
		tArr[0] = t;
		//修改栈顶
		top = top + 1;
		return true;
	}
	
	
	//出栈
	public Object pop() {
		//栈满了，出栈失败
		if (top == -1) {
			System.out.println("空栈");
			return null;
		}
		Object obj = tArr[0];
		if (top != 0) {
			for(int i=0;i<top;i++) {
				tArr[i] = tArr[i+1];
			}
		}
		tArr[top] = null;
		//修改栈顶
		top = top - 1;
		return obj;
	}
	
	public static void main(String[] args) {
		Stack<String> stack2 = new Stack<>(3);
		//压入数据
		stack2.push("苏登辉1");
		stack2.push("苏登辉2");
		stack2.push("苏登辉3");
		stack2.push("苏登辉4");
		stack2.push("苏登辉5");
		
		//弹出数据
		stack2.pop();
		stack2.pop();
		stack2.pop();
		stack2.pop();
		stack2.pop();
	}
	
}















