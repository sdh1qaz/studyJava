/**
 * @ClassName： UserDir
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年1月17日
 */

public class UserDir {
	public static void main(String[] args) {
		//System.out.println(System.getProperty("user.dir"));
		String s = "6";
		if(!"5".equals(s) || !"6".equals(s))
			System.out.println("嘿嘿");
		
		String s1 = "你你我你";
		String s2 = s1.replace("你", "我").replace("我", "o");
		s1.replace("你", "我").replace("我", "o");
		System.out.println(s2);
	}

}
