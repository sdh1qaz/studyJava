/**
 * @ClassName： TimeUnitTest
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2018年7月4日
 */
class A{
	public static final String time = "2008";
}

class B extends A{
	void say() {
		System.out.println(time);
	}
}

public class TimeUnitTest {
     public static void main(String[] args) {
		//System.out.println(TimeUnit.SECONDS);
    	 //System.out.println("nih" + 1 + 1);
    	new B().say();
	}
}
