package 异常exception;

public class Test {
    public static void main(String[] args) {
    	try {
    		System.out.println(7 / 0);
		} catch (ArithmeticException e) {
			System.out.println("遇到了ArithmeticException异常，但程序继续执行");
		}
    	finally{
    		System.out.println("最后执行了finally语句");
    	}
		
	}
} 
